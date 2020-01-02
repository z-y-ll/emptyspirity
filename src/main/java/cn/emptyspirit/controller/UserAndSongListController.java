package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.expand.SongListExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.UserAndSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("userAndSongList")
@CrossOrigin
public class UserAndSongListController {

    private UserAndSongListService userAndSongListService;

    @Autowired
    public UserAndSongListController(UserAndSongListService userAndSongListService) {
        this.userAndSongListService = userAndSongListService;
    }


    /**
     * 根据歌单id，收藏歌单
     * @param songListId 歌单id
     * @return
     */
    @PostMapping("/addFavoriteSongList")
    public R addFavoriteSongList(Integer songListId, Integer userId/*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        Integer result = userAndSongListService.addFavoriteSongList(songListId, userId);
        switch (result) {
            case 1:
                return R.ok("取消收藏");
            case 2:
                return R.ok("收藏成功");
            default:
                return R.error("操作异常");
        }
    }


    /**
     * 取消收藏歌单，根据歌单id
     * @param songListId
     * @return
     */
    @PostMapping("/deleteFavoriteSongList")
    public R deleteFavoriteSongList(Integer songListId, Integer userId/*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        return userAndSongListService.deleteFavoriteSongList(songListId, userId) > 0
                ? R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 获取用户收藏的全部歌单
     * @return
     * @throws Exception
     */
    @GetMapping("/getFavoriteSongList/{userId}")
    public R getFavoriteSongList(@PathVariable("userId") Integer userId /*HttpSession session*/) throws Exception{
//        User user = (User) session.getAttribute("user");
        List<SongListExpand> songList =
                userAndSongListService.selectFavoriteSongListByUserId(userId);
        if (songList == null || songList.isEmpty()) {
            return R.no();
        }
        return R.ok(songList);
    }
}
