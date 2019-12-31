package cn.emptyspirit.service;

import cn.emptyspirit.entity.expand.SongExpand;
import com.github.pagehelper.PageInfo;

/**
 * @Author: zyll
 * @Date: 2019/12/27 23:15
 * @Version 1.0
 */

public interface SongService {
    /**
     * 查询所有歌曲(默认排序)
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsById (Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 获取所有歌曲(根据受欢迎度排序)
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsByLike (Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 获取所有歌曲(根据播放量排序)
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsByPlay (Integer pageNum, Integer pageSize) throws Exception;
    /**
     * 根据类型id分类歌曲
     * @param typeid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsByType (Integer typeid, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     * @throws Exception
     */
    SongExpand getSongById(Integer id) throws Exception;

    /**
     * 根据歌手id来查询歌曲
     * @param singerid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsBySinger (Integer singerid,  Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 通过歌单的id来查询歌曲
     * @param songlistid
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<SongExpand> getSongsBySongList(Integer songlistid, Integer pageNum, Integer pageSize) throws  Exception;

    /**
     * 根据歌曲名字模糊查询
     * @param songname
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
    PageInfo<SongExpand> getSongsLikeName(String songname, Integer pageNum, Integer pageSize) throws Exception;
    */
}
