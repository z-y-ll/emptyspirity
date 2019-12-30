package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.SongListAndSong;
import cn.emptyspirit.mapper.SongListAndSongMapper;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.service.SongService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


/**
 * @Author: zyll
 * @Date: 2019/12/28 0:00
 * @Version 1.0
 */
@Service
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;
    private SongListAndSongMapper songListAndSongMapper;

    @Autowired
    public SongServiceImpl(SongMapper songMapper, SongListAndSongMapper songListAndSongMapper) {
        this.songMapper = songMapper;
        this.songListAndSongMapper = songListAndSongMapper;
    }

    /**
     * 查询所有歌曲
     *
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(cacheNames = {"songs"})
    public PageInfo<Song> getSongs(Integer pageNum, Integer pageSize) throws Exception {
        Wrapper<Song> wrapper = Wrappers.<Song>lambdaQuery();
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.selectList(wrapper));
    }

    /**
     * 根据类型id分类歌曲
     *
     * @param typeid
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Song> getSongsByType(Integer typeid, Integer pageNum, Integer pageSize) throws Exception {
        Wrapper<Song> wrapper = Wrappers.<Song>lambdaQuery().eq(Song::getId, typeid);
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.selectList(wrapper));
    }

    /**
     * 根据id查询歌曲
     *
     * @return
     * @throws Exception
     */
    @Override
    public Song getSongById(Integer id) throws Exception {
        return songMapper.selectById(id);
    }

    /**
     * 根据歌手id来查询歌曲
     *
     * @param singerid
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Song> getSongsBySinger(Integer singerid, Integer pageNum, Integer pageSize) throws Exception {
        Wrapper<Song> wrapper = Wrappers.<Song>lambdaQuery().eq(Song::getId, singerid);
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.selectList(wrapper));
    }

    /**
     * 通过歌单的id来查询歌曲
     *
     * @param songlistid
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Song> getSongsBySongList(Integer songlistid, Integer pageNum, Integer pageSize) throws Exception {
        List<SongListAndSong> list = songListAndSongMapper.selectList(Wrappers.<SongListAndSong>lambdaQuery().eq(SongListAndSong::getSonglistId, songlistid));
        if (list.isEmpty()){
            return null;
        }else {
            List<Integer> ids = new LinkedList<>();
            for (SongListAndSong songlistandsong : list ) {
                ids.add(songlistandsong.getSongId());
            }
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.selectBatchIds(ids));
        }
    }
}

