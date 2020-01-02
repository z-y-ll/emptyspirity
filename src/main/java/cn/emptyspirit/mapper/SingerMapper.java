package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

/**
 * @author zyll
 */
@Mapper
public interface SingerMapper extends BaseMapper<Singer> {
    /**
     * 根据喜好程度来查询歌手
     * @return
     */

    List<Singer> getSingsByLike();

    /**
     * 根据歌手名字模糊查询歌手
     * @param singerName
     * @return
     */
//    @Select("select * from t_singer where singer_name like '%${value }%'")
//    List<Singer> selectSingerByLikeName(String singerName);
}