package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.expand.SongExpand;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.service.SongService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: zyll
 * @Date: 2019/12/28 0:00
 * @Version 1.0
 */
@Service
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;

    @Autowired
    public SongServiceImpl(SongMapper songMapper) {
        this.songMapper = songMapper;
    }

    /**
     * 查询所有歌曲(默认排序)
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsById(Integer pageNum, Integer pageSize) throws Exception {
       return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsById());
    }

    /**
     * 获取所有歌曲(根据受欢迎度排序)
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsByLike(Integer pageNum, Integer pageSize) throws Exception {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsByLike());
    }

    /**
     * 获取所有歌曲(根据播放量排序)
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsByPlay(Integer pageNum, Integer pageSize) throws Exception {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsByPlay());
    }

    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsByType(Integer typeid, Integer pageNum, Integer pageSize) throws Exception {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsByType(typeid));
    }

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SongExpand getSongById(Integer id) throws Exception {
        Song song = songMapper.selectById(id);
        song.setPlayNumber(song.getPlayNumber() + 1);
        songMapper.updateById(song);
        return songMapper.getSongById(id);
    }

    /**
     * 根据歌手id来查询歌曲
     * @param singerid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsBySinger(Integer singerid, Integer pageNum, Integer pageSize) throws Exception {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsBySinger(singerid));
    }

    /**
     * 通过歌单的id来查询歌曲
     * @param songlistid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<SongExpand> getSongsBySongList(Integer songlistid, Integer pageNum, Integer pageSize) throws Exception {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsBySongList(songlistid));
    }

    /**
     * 根据歌曲名字模糊查询
     *
     * @param songname
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
    @Override
    public PageInfo<SongExpand> getSongsLikeName(String songname, Integer pageNum, Integer pageSize) throws Exception {
        if (songname == null){
            throw  new ParamException();
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> songMapper.getSongsLikeName(songname));
    }
    */
}

