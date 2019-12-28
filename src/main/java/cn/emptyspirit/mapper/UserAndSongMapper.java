package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.UserAndSong;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}