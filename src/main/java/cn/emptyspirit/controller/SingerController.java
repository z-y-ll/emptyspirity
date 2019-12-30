package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 15:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/singer")
public class SingerController {
    private final SingerService singerService;

    @Autowired
    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    /**
     * 查询所有的歌手
     * @return
     * @throws Exception
     */
    @GetMapping("/getSingers")
    public R getSingers() throws Exception {
        List<Singer> singers = singerService.getSingers();
        return singers.isEmpty() ? R.no() : R.ok(singers);
    }

    /**
     * 根据歌手的名字查询歌手
     * @param singerName
     * @return
     * @throws Exception
     */
    @GetMapping("/getSingerByName/{singerName}")
    public R getSingerByName(@PathVariable("singerName") String singerName) throws Exception {
        Singer singer = singerService.getSingerByName(singerName);
        return singer == null ? R.no() : R.ok(singer);
    }
}
