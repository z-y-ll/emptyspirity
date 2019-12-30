package cn.emptyspirit.service.impl;

import cn.emptyspirit.constant.FileUploadConstant;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.UserAndSong;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.global.FileUtil;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.mapper.UserAndSongMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private SongMapper songMapper;
    private UserAndSongMapper userAndSongMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, SongMapper songMapper, UserAndSongMapper userAndSongMapper) {
        this.userMapper = userMapper;
        this.songMapper = songMapper;
        this.userAndSongMapper = userAndSongMapper;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) throws Exception{
        if (id == null) {
            throw new ParamException();
        }
        return userMapper.selectUnbannedUserById(id);
    }


    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public User selectUserByNameAndPwd(String username, String password) throws Exception {
        if (username == null || password == null) {
            throw new ParamException();
        }
        List<User> users = userMapper.selectUserByName(username);
        // 无此用户
        if (users == null || users.isEmpty()) {
            return null;
        }
        // 若查询出多个用户，则数据异常，因为用户名唯一
        if (users.size() > 1) {
            throw new ParamException("账号异常");
        }

        // 判断密码是否一致
        User user = users.get(0);
        return password.equals(user.getPassword()) ? user : null;
    }


    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Integer userRegister(String username, String password) throws Exception {
        if (username == null || password == null || "".equals(username) || "".equals(password)) {
            throw new ParamException();
        }
        // 判断用户名是否已经存在
        List<User> users = userMapper.selectUserByName(username);
        if (users != null && !users.isEmpty()) {
            throw new ParamException("用户名已存在");
        }
        // 向数据库中插入一条记录
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        return userMapper.insert(user);
    }


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User selectUserByName(String username) throws Exception {
        if (username == null) {
            throw new ParamException();
        }
        // 判断用户是否存在
        List<User> users = userMapper.selectUserByName(username);
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }


    /**
     * 修改用户密码
     * @param id 用户id
     * @param newPassword 新密码
     * @return
     * @throws Exception
     */
    @Override
    public Boolean updateUserPassword(Integer id, String newPassword) throws Exception {
        if (id == null || newPassword == null || "".equals(newPassword)) {
            throw new ParamException();
        }
        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(id);
        if (user == null) {
            throw new ParamException("用户不存在");
        }

        // 判断新旧密码一致，则不用修改
        if (newPassword.equals(user.getPassword())) {
            return true;
        }

        // 更新密码
        user.setPassword(newPassword);
        Integer result = userMapper.updateById(user);
        return result > 0 ? true : false;
    }


    /**
     * 需改用户头像
     * @param avatar 头像文件
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @Override
    public String changeAvatar(MultipartFile avatar, Integer userId) throws Exception {
        if (userId == null || avatar == null) {
            throw new ParamException();
        }
        if (avatar.isEmpty()) {
            throw new ParamException("文件不能为空");
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户不存在");
        }

        // 随机文件名称
        String avatarName = FileUtil.randomFileName(avatar);
        System.out.println(avatarName);
        // 拼凑文件路径
        String path = FileUploadConstant.ROOT_PATH + FileUploadConstant.AVATAR_PATH + avatarName;
        avatar.transferTo(new File(path));

        // 更新数据库
        user.setAvatar(FileUploadConstant.AVATAR_PATH + avatarName);
        userMapper.updateById(user);

        // 返回新路径
        return FileUploadConstant.AVATAR_PATH + avatarName;
    }


}