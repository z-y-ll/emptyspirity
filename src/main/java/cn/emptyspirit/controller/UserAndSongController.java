package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.expand.SongExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.UserAndSongService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户收藏歌曲相关操作
 */
@RestController
@RequestMapping("userAndSong")
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
    public R addFavoriteSong(Integer songId, HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        return userAndSongService.addFavoriteSong(songId, user.getId()) > 0 ?
                R.ok("收藏成功") : R.error("收藏失败");
    }


    /**
     * 用户取消一首歌的收藏
     * @param userAndSongId 收藏表中，这条收藏记录的id
     * @return
     */
    @PostMapping("/deleteFavoriteSong")
    public R deleteFavoriteSong(@RequestParam("id") Integer userAndSongId,
                                HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return userAndSongService.deleteFavoriteSongById(userAndSongId, user.getId()) > 0 ?
                R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 根据歌曲id，取消用户对此歌曲的收藏
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteFavoriteBySongId")
    public R deleteFavoriteBySongId(Integer songId, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return userAndSongService.deleteFavoriteBySongId(songId, user.getId()) > 0 ?
                R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 查询用户收藏的歌曲
     * @param session
     * @return
     */
    @GetMapping("/getFavoriteSongs")
    public R getFavoriteSongs(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        List<SongExpand> songs = userAndSongService.selectFavoriteSongsByUserId(user.getId());
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
                                     HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        PageInfo<SongExpand> pageInfo =
                userAndSongService.getOnePageFavoriteSongs(pageNum, pageSize, user.getId());
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

}
