package cn.emptyspirit.service;

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
}
