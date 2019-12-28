package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 用户模块：用户相关操作
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
     * 用户登出
     */
    @GetMapping("/logout")
    public R logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return R.error("请先登录");
        }
        session.removeAttribute("user");
        return R.ok("退出成功");
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


    /**
     * 通过用户名判断用户是否存在
     * 此方法提供给前端注册时使用
     * 判断用户名是否重复
     * @return
     */
    @GetMapping("/getUserByName/{username}")
    public R getUserByName(@PathVariable("username") String username) throws Exception {
        return userService.selectUserByName(username) == null ? R.no("无此用户") : R.ok("用户名存在");
    }


    /**
     * 修改密码
     * @return
     */
    @PostMapping("/changePassword")
    public R changePassword(String newPassword, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");

        //判断修改结果
        if (userService.updateUserPassword(user.getId(), newPassword)) {
            // 更新session中的user数据
            user.setPassword(newPassword);
            return R.ok("修改成功");
        }
        return R.error("修改失败");
    }


    /**
     * 测试接口
     */
    @GetMapping("/test/{test}")
    public R test(@PathVariable("test") String test) {
        System.out.println(test);
        return R.ok(test);
    }

}
