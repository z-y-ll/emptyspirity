package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/29 15:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/singer")
@CrossOrigin
public class SingerController {
    private final SingerService singerService;

    @Autowired
    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    /**
     * 查询所有的歌手(默认顺序)
     * @return
     * @throws Exception
     */
    @GetMapping("/getSingersOrderById")
    public R getSingersById() throws Exception {
        List<Singer> singers = singerService.getSingersById();
        return singers.isEmpty() ? R.no() : R.ok(singers);
    }
    /**
     * 查询所有的歌手
     * @return
     * @throws Exception
     */
    @GetMapping("/getSingersOrderByLike")
    public R getSingersByLike() throws Exception {
        List<Singer> singers = singerService.getSingersByLike();
        return singers.isEmpty() ? R.no() : R.ok(singers);
    }
    /**
     * 根据歌手的id查询歌手
     * @param singerId
     * @return
     * @throws Exception
     */
    @GetMapping("/getSingerById/{singerId}")
    public R getSingerByName(@PathVariable("singerId") String singerId) throws Exception {
        Singer singer = singerService.getSingerByName(singerId);
        return singer == null ? R.no() : R.ok(singer);
    }

    /**
     * 根据歌手名称模糊查询歌手
     * @param singname
     * @return
     * @throws Exception
     */
//    @GetMapping("/getSingersLikeName")
//    public R getSongsLikeName(String singname) throws Exception{
//        List<Singer> singerList = singerService.getSingersLikeName(singname);
//        return singerList.isEmpty() ? R.no() : R.ok(singerService);
//    }


}
