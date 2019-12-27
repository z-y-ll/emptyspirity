package cn.emptyspirit.controller;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:17
 * @Version 1.0
 */
@RestController
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/songs/{songtype}")
    public R getSongs(@PathVariable("songtype") String songtype){
        List songs = songService.getSongByType(songtype);
        if (songs.size() == 0){
            return R.no("没有该类型的歌曲");
        }else {
            return R.ok(songs, "查询成功");
        }
    }
}
