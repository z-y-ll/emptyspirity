package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(Integer id) throws Exception{
        if (id == null) {
            throw new ParamException();
        }
        return userMapper.selectById(id);
    }



}