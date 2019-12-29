package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.UserAndSong;
import cn.emptyspirit.entity.expand.SongExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 */
public interface UserAndSongMapper extends BaseMapper<UserAndSong> {

    /**
     * 根据用户id和歌曲id，查询用户收藏歌曲记录
     * @param songId 歌曲id
     * @param userId 用户id
     * @return
     */
    @Select("select id, user_id, song_id from t_user_song where user_id = #{userId} " +
            "and song_id = #{songId}")
    UserAndSong selectBySongIdAndUserId(@Param("songId") Integer songId,
                                        @Param("userId") Integer userId) throws Exception;


    /**
     * 查询用户收藏的歌曲
     * @param userId
     * @return
     */
    List<SongExpand> selectFavoriteSongsByUserId(Integer userId) throws Exception;
}