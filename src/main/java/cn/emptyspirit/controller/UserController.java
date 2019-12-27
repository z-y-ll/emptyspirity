package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户模块
 */
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 用户登录
     * @param id
     * @return
     */
    @PostMapping("/login")
    public R login(Integer id){
        return R.ok("aaaaaaaaaaaaaaaaaaa");
    }


}
