package cn.emptyspirit.controller;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.SongService;
import com.github.pagehelper.PageInfo;
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
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    /**
     * 查询所有歌曲
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongs")
    public R getSongs(@RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<Song> pageInfo = songService.getSongs(pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);

    }
    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsByTypeid/{typeid}")
    public R getSongsByType(@PathVariable("typeid") Integer typeid,
                            @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize) throws Exception {
        PageInfo<Song> pageInfo = songService.getSongsByType(typeid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

    /**
     * 根据主键查询一首歌曲
     * @param id
     * @return
     */
    @GetMapping("/getSongById/{id}")
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
    @GetMapping("/getSongsBySingerid/{singerid}")
    public R getSongsBySinger(@PathVariable("singerid") Integer singerid,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) throws Exception {
        PageInfo<Song> pageInfo = songService.getSongsBySinger(singerid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

    /**
     * 根据歌单id来查找歌曲
     * @param songlistid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsBySonglistid/{songlistid}")
    public R getSongsBySongList(@PathVariable("songlistid") Integer songlistid,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "5") Integer pageSize) throws Exception{
        PageInfo<Song> pageInfo = songService.getSongsBySongList(songlistid, pageNum, pageSize);
        return pageInfo.getTotal() == 0 ? R.no() : R.ok(pageInfo);
    }

}
