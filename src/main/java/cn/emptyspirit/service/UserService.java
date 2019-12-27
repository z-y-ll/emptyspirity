package cn.emptyspirit.service;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zyll
 * @Date: 2019/12/27 15:17
 * @Version 1.0
 */
@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Integer id){
        return userMapper.selectById(id);
    }

}
