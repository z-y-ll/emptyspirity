package cn.emptyspirit.controller;

import cn.emptyspirit.entity.expand.SongExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.UserAndSongService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户收藏歌曲相关操作
 */
@RestController
@RequestMapping("/userAndSong")
@CrossOrigin
@Api(value = "用户歌曲模块", tags = "用户歌曲模块相关的接口")
public class UserAndSongController {

    private final UserAndSongService userAndSongService;

    @Autowired
    public UserAndSongController(UserAndSongService userAndSongService) {
        this.userAndSongService = userAndSongService;
    }


    /**
     * 用户收藏歌曲
     * @param songId 歌曲id
     * @return
     * @throws Exception
     */
    @PostMapping("/addFavoriteSong")
    public R addFavoriteSong(Integer songId, Integer userId/*HttpSession session*/) throws Exception{
//        User user = (User) session.getAttribute("user");
        Integer result = userAndSongService.addFavoriteSong(songId, userId);
        switch (result) {
            case 1:
                return R.ok("收藏成功");
            case 2:
                return R.ok("取消收藏成功");
            default:
                return R.error("操作失败");
        }
    }


    /**
     * 用户取消一首歌的收藏
     * @param userAndSongId 收藏表中，这条收藏记录的id
     * @return
     */
    @PostMapping("/deleteFavoriteSong")
    public R deleteFavoriteSong(@RequestParam("id") Integer userAndSongId,
                                Integer userId/*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        return userAndSongService.deleteFavoriteSongById(userAndSongId, userId) > 0 ?
                R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 根据歌曲id，取消用户对此歌曲的收藏
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteFavoriteBySongId")
    public R deleteFavoriteBySongId(Integer songId, Integer userId/*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        return userAndSongService.deleteFavoriteBySongId(songId, userId) > 0 ?
                R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 查询用户收藏的歌曲
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @GetMapping("/getFavoriteSongs/{userId}")
    public R getFavoriteSongs(@PathVariable("userId") Integer userId/*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        List<SongExpand> songs = userAndSongService.selectFavoriteSongsByUserId(userId);
        if (songs == null || songs.isEmpty()) {
            return R.no();
        }
        return R.ok(songs);
    }


    /**
     * 查询用户收藏的歌曲
     * 分页查询
     * @return
     */
    @GetMapping("/getOnePageFavoriteSongs")
    public R getOnePageFavoriteSongs(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "2") Integer pageSize,
                                     Integer userId /*HttpSession session*/) throws Exception {
//        User user = (User) session.getAttribute("user");
        PageInfo<SongExpand> pageInfo =
                userAndSongService.getOnePageFavoriteSongs(pageNum, pageSize, userId);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }
}
