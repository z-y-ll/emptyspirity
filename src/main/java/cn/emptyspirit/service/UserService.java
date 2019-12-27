package cn.emptyspirit.service;

import cn.emptyspirit.entity.User;
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


}
