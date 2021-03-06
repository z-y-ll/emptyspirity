package cn.emptyspirit.controller;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.expand.SongExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SongService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/song")
@CrossOrigin
@Api(value = "歌曲模块", tags = "歌曲模块相关的接口")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    /**
     * 查询所有歌曲(默认排序)
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsOrderById")
    @ApiOperation(value = "查询所有歌曲(默认排序)", notes = "根据id默认排序查询所有歌曲")
    public R getSongsByid(@RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<SongExpand> pageInfo = songService.getSongsById(pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }
    /**
     * 查询所有歌曲(喜好排序)
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsOrderByLike")
    @ApiOperation(value = "查询所有歌曲(按照用户喜好排序)", notes = "根据用户的喜爱数量排序查询所有歌曲")
    public R getSongsByLike(@RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<SongExpand> pageInfo = songService.getSongsByLike(pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }
    /**
     * 查询所有歌曲(播放量排序)
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsOrderByPlay")
    @ApiOperation(value = "查询所有歌曲(按照播放量排序)", notes = "根据用户的播放量排序查询所有歌曲")
    public R getSongsByPlay(@RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<SongExpand> pageInfo = songService.getSongsByPlay(pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }
    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsByTypeid/{typeId}")
    @ApiOperation(value = "根据类型id查询歌曲", notes = "根据获取的类型id来查询歌曲")
    public R getSongsByType(@PathVariable("typeId") Integer typeid,
                            @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize) throws Exception {
        PageInfo<SongExpand> pageInfo = songService.getSongsByType(typeid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

    /**
     * 根据主键查询一首歌曲
     * @param id
     * @return
     */
    @GetMapping("/getSongById/{id}")
    @ApiOperation(value = "根据歌曲id查询歌曲", notes = "根据获取的歌曲id来查询歌曲")
    public R getSongsById(@PathVariable("id") Integer id) throws Exception {
        Song nowsong = songService.getSongById(id);
        return nowsong == null ? R.no() : R.ok(nowsong);
    }

    /**
     * 根据歌手id来查询歌曲
     * @param singerid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsBySingerid/{singerId}")
    @ApiOperation(value = "根据歌手id查询歌曲", notes = "根据获取的歌手id来查询歌曲")
    public R getSongsBySinger(@PathVariable("singerId") Integer singerid,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize) throws Exception {
        PageInfo<SongExpand> pageInfo = songService.getSongsBySinger(singerid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

    /**
     * 根据歌单id来查找歌曲
     * @param songlistid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsBySonglistid/{songlistid}")
    @ApiOperation(value = "根据歌单id查询歌曲", notes = "根据获取的歌单id来查询歌曲")
    public R getSongsBySongList(@PathVariable("songlistid") Integer songlistid,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<SongExpand> pageInfo = songService.getSongsBySongList(songlistid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

    /**
     * 根据歌曲名称模糊查询
     * @param songname
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception

    @GetMapping("/getSongsLikeName")
    public R getSongsLikeName(String songname,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) throws Exception {
        PageInfo<SongExpand> pageInfo = songService.getSongsLikeName(songname, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }
    */
}
