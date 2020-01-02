package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.UserAndSingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户和歌手的相关操作
 */
@RestController
@RequestMapping("/userAndSinger")
@CrossOrigin
public class UserAndSingerController {

    private UserAndSingerService userAndSingerService;

    @Autowired
    public UserAndSingerController(UserAndSingerService userAndSingerService) {
        this.userAndSingerService = userAndSingerService;
    }


    /**
     * 用户关注歌手
     * @param singerId 歌手id
     * @return
     * @throws Exception
     */
    @PostMapping("/addFollowSinger")
    public R addFollowSinger(Integer singerId, Integer userId /*HttpSession session*/) throws Exception{
//        User user = (User) session.getAttribute("user");
        return userAndSingerService.addFollowSinger(singerId, userId) > 0 ?
                R.ok("关注成功") : R.error("关注失败");
    }


    /**
     * 用户通过歌手id，取消关注该歌手
     * @param singerId 歌手id
     * @return
     */
    @PostMapping("/deleteFollowSinger")
    public R deleteFollowSinger(Integer singerId, Integer userId/*HttpSession session*/) throws Exception{
//        User user = (User) session.getAttribute("user");
        return userAndSingerService.deleteFollowSingerBySingerId(singerId, userId) > 0
                ? R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 获取用户关注的所有歌手
     * @return
     */
    @GetMapping("/getFollowSingers/{userId}")
    public R getFollowSingers(@PathVariable("userId") Integer userId /*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        List<Singer> singers = userAndSingerService.selectFollowSingersByUserId(userId);
        if (singers == null || singers.isEmpty()) {
            return R.no();
        }
        return R.ok(singers);
    }

}
