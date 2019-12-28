package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    public R register(String username, String password) throws Exception {
        return userService.userRegister(username, password) > 0 ? R.ok("注册成功") : R.error("注册失败");
    }


    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public R login(String username, String password, HttpSession session) throws Exception {
        User user = userService.selectUserByNameAndPwd(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return R.ok(user);
        }
        return R.no("用户名或密码错误");
    }


    /**
     * 根据userid查询用户
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserById/{userId}")
    public R getUserById(@PathVariable("userId") Integer userId) throws Exception {
        User user = userService.getUserById(userId);
        return user == null ? R.no() : R.ok(user);
    }


    /**
     * 获取用户信息
     * 从session中获取
     * @return
     * @throws Exception
     */
    @GetMapping("/getUserInfo")
    public R getUserInfo(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return user == null ? R.no() : R.ok(user);
    }



}
