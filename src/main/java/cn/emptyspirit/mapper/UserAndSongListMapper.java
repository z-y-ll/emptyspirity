package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.UserAndSongList;
import cn.emptyspirit.entity.expand.SongListExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zyll
 */
public interface UserAndSongListMapper extends BaseMapper<UserAndSongList> {

    /**
     * 根据用户id和歌单id，查询一条收藏记录
     * @param songListId 歌单id
     * @param userId    用户id
     * @return
     */
    @Select("select * from t_user_songlist where user_id = #{userId} " +
            "and songlist_id = #{songListId}")
    UserAndSongList selectBySongListIdAndUserId(@Param("songListId") Integer songListId,
                                                @Param("userId") Integer userId) throws Exception;


    /**
     * 查询用户收藏的全部歌单
     * @param userId
     * @return
     * @throws Exception
     */
    List<SongListExpand> selectFavoriteSongListByUserId(Integer userId) throws Exception;

}