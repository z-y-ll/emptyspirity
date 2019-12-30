package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.entity.UserAndSinger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zyll
 */
@Mapper
public interface UserAndSingerMapper extends BaseMapper<UserAndSinger> {

    /**
     * 查询用户关注歌手的桥表记录
     * @param singerId 歌手id
     * @param userId 用户id
     * @return
     */
    @Select("SELECT*FROM t_user_singer WHERE singer_id=#{singerId} AND user_id=#{userId}")
    UserAndSinger selectBySingerIdAndUserId(@Param("singerId") Integer singerId,
                                            @Param("userId") Integer userId) throws Exception;


    /**
     * 查询用户关注的所有歌手
     * @param userId
     * @return
     */
    @Select("select c.id, c.singer_name, c.avatar, c.age, c.gender, c.introduction " +
            "from t_user a " +
                "inner join t_user_singer b on a.id = #{userId } and a.id = b.user_id " +
                "left join t_singer c on b.singer_id = c.id")
    List<Singer> selectFollowSingersByUserId(Integer userId);
}