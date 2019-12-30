package cn.emptyspirit.service;


import cn.emptyspirit.entity.Song;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:15
 * @Version 1.0
 */

public interface SongService {
    /**
     * 查询所有歌曲
     * @return
     * @throws Exception
     */
    List<Song> getSongs() throws Exception;
    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @return
     * @throws Exception
     */
    List<Song> getSongsByType(Integer typeid) throws Exception;

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     * @throws Exception
     */
    Song getSongById(Integer id) throws Exception;

    /**
     * 根据歌手id来查询歌曲
     * @param singerid
     * @return
     * @throws Exception
     */
    List<Song> getSongsBySinger(Integer singerid) throws Exception;

    /**
     * 通过歌单的id来查询歌曲
     * @param songlistid
     * @return
     * @throws Exception
     */
    List<Song> getSongsBySongList(Integer songlistid) throws  Exception;
}
