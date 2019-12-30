package cn.emptyspirit.service;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
