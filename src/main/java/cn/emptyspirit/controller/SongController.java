package cn.emptyspirit.controller;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.globel.R;
import cn.emptyspirit.service.SongService;
import cn.emptyspirit.service.TypeService;
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
    public R getSongs() throws Exception{
        List<Song> songList = songService.getSongs();
        return songList.isEmpty() ? R.no() : R.ok(songList);

    }
    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongsByTypeid/{typeid}")
    public R getSongsByType(@PathVariable("typeid") Integer typeid) throws Exception {
        List<Song> songList = songService.getSongsByType(typeid);
        return songList.isEmpty() ? R.no() : R.ok(songList);
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
    public R getSongsBySinger(@PathVariable("singerid") Integer singerid) throws Exception {
        List<Song> songList = songService.getSongsBySinger(singerid);
        return songList.isEmpty() ? R.no() : R.ok(songList);
    }

    @GetMapping("/getSongsBySonglistid/{songlistid}")
    public R getSongsBySongList(@PathVariable("songlistid") Integer songlistid) throws Exception{
        List<Song> songList = songService.getSongsBySongList(songlistid);
        return songList.isEmpty() ? R.no() : R.ok(songList);
    }
}
