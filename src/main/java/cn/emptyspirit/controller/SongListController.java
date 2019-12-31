package cn.emptyspirit.controller;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 19:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/songlist")
@CrossOrigin
public class SongListController {
    private final SongListService songListService;

    @Autowired
    public SongListController(SongListService songListService) {
        this.songListService = songListService;
    }

    /**
     * 查询所有歌单，根据喜好降序排序
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongLists")
    public R getSongLists() throws Exception {
        List<SongList> songLists = songListService.getSongLists();
        return songLists.isEmpty() ? R.no() : R.ok(songLists);
    }

    /**
     * 根据查询歌单
     * @param songlistid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongListById/{songlistid}")
    public R getSongById(@PathVariable("songlistid") Integer songlistid) throws Exception {
        SongList songList = songListService.getSongListById(songlistid);
        return songList == null ? R.no() : R.ok(songList);
    }
}
