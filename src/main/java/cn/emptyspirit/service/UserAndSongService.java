package cn.emptyspirit.service;

import cn.emptyspirit.entity.expand.SongExpand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserAndSongService {


    /**
     * 用户收藏歌曲
     * @param songId 歌曲id
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    Integer addFavoriteSong(Integer songId, Integer userId)throws Exception;


    /**
     * 用户取消一首歌的收藏
     * @param userAndSongId 收藏歌曲的桥表中，这条收藏记录
     * @param userId
     * @return
     * @throws Exception
     */
    Integer deleteFavoriteSongById(Integer userAndSongId, Integer userId) throws Exception;


    /**
     * 根据歌曲id，取消用户对这首歌的收藏
     * @param songId 歌曲id
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    Integer deleteFavoriteBySongId(Integer songId, Integer userId) throws Exception;


    /**
     * 查询用户收藏的所有歌曲
     * @param userId 用户的名字
     * @return
     */
    List<SongExpand> selectFavoriteSongsByUserId(Integer userId) throws Exception;


    /**
     * 分页查询用户的所有收藏歌曲
     * @param pageNum 页号
     * @param pageSize 页面大小
     * @param userId 用户id
     * @return
     */
    PageInfo<SongExpand> getOnePageFavoriteSongs(Integer pageNum, Integer pageSize, Integer userId) throws Exception;
}
