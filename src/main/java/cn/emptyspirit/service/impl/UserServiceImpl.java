package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.UserAndSong;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.mapper.UserAndSongMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        // 更新密码
        user.setPassword(newPassword);
        Integer result = userMapper.updateById(user);
        return result > 0 ? true : false;
    }


}