package cn.emptyspirit.service;

import cn.emptyspirit.entity.expand.SongListExpand;
import cn.emptyspirit.globel.R;

import java.util.List;

public interface UserAndSongListService {

    /**
     * 用户收藏歌单，根据歌单id
     * @param songListId
     * @param userId
     * @return
     */
    Integer addFavoriteSongList(Integer songListId, Integer userId) throws Exception;


    /**
     * 用户取消关注歌单，根据歌单id
     * @param songListId
     * @param userId
     * @return
     */
    Integer deleteFavoriteSongList(Integer songListId, Integer userId) throws Exception;


    /**
     * 查询用户关注的所有歌单
     * @param userId 用户id
     * @return
     */
    List<SongListExpand> selectFavoriteSongListByUserId(Integer userId) throws Exception;
}
