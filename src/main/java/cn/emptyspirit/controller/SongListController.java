package cn.emptyspirit.controller;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 19:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/songlist")
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
}
