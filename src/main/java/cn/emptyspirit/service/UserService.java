package cn.emptyspirit.service;

import cn.emptyspirit.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {


    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(Integer id) throws Exception;

    /**
     * 根据用户名或密码查找用户
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User selectUserByNameAndPwd(String username, String password) throws Exception;

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    Integer userRegister(String username, String password) throws Exception;


    /**
     * 根据用户名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    User selectUserByName(String username) throws Exception;


    /**
     * 修改密码
     * @param id 用户id
     * @param newPassword 新密码
     * @return
     */
    Boolean updateUserPassword(Integer id, String newPassword) throws Exception;


    /**
     * 修改用户头像
     * @param avatar 头像文件
     * @param userId
     * @return
     */
    String changeAvatar(MultipartFile avatar, Integer userId) throws Exception;
}
