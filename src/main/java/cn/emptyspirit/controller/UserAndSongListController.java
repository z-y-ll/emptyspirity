package cn.emptyspirit.controller;

import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.expand.SongListExpand;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.UserAndSongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("userAndSongList")
public class UserAndSongListController {

    private UserAndSongListService userAndSongListService;

    @Autowired
    public UserAndSongListController(UserAndSongListService userAndSongListService) {
        this.userAndSongListService = userAndSongListService;
    }


    /**
     * 根据歌单id，收藏歌单
     * @param songListId 歌单id
     * @param session
     * @return
     */
    @PostMapping("/addFavoriteSongList")
    public R addFavoriteSongList(Integer songListId, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return userAndSongListService.addFavoriteSongList(songListId, user.getId()) > 0 ?
                R.ok("收藏成功") : R.error("收藏失败");
    }


    /**
     * 取消收藏歌单，根据歌单id
     * @param songListId
     * @param session
     * @return
     */
    @PostMapping("/deleteFavoriteSongList")
    public R deleteFavoriteSongList(Integer songListId, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        return userAndSongListService.deleteFavoriteSongList(songListId, user.getId()) > 0
                ? R.ok("取消成功") : R.error("取消失败");
    }


    /**
     * 获取用户收藏的全部歌单
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/getFavoriteSongList")
    public R getFavoriteSongList(HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        List<SongListExpand> songList =
                userAndSongListService.selectFavoriteSongListByUserId(user.getId());
        if (songList == null || songList.isEmpty()) {
            return R.no();
        }
        return R.ok(songList);
    }
}
