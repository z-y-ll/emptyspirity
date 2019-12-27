package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zyll
 * @Date: 2019/12/27 15:17
 * @Version 1.0
 */
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/login/{id}")
    public R login(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return R.ok(user );
    }
}
