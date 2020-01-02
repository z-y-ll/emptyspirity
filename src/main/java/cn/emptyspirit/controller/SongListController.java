package cn.emptyspirit.controller;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.entity.expand.SongListExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "歌单模块", tags = "歌单模块相关的接口")
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
    @ApiOperation(value = "根据喜好程度查询所有歌单", notes = "根据用户关注程度来查询所有歌单")
    public R getSongLists() throws Exception {
        List<SongListExpand> songLists = songListService.getSongLists();
        return songLists.isEmpty() ? R.no() : R.ok(songLists);
    }

    /**
     * 根据查询歌单
     * @param songlistid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongListById/{songlistid}")
    @ApiOperation(value = "根据歌单id查询歌单", notes = "通过获取的歌单id来查询歌单")
    public R getSongById(@PathVariable("songlistid") Integer songlistid) throws Exception {
        SongList songList = songListService.getSongListById(songlistid);
        return songList == null ? R.no() : R.ok(songList);
    }
}
