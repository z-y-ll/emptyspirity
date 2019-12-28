package cn.emptyspirit.controller;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/song")
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    /**
     * 根据类型来查找歌曲
     * @param songtype
     * @return
     */
    @GetMapping("/songs/{songtype}")
    public R getSongs(@PathVariable("songtype") String songtype) throws Exception {
        List songs = songService.getSongByType(songtype);
        return songs.size() == 0 ? R.no() : R.ok(songs);
    }
}
