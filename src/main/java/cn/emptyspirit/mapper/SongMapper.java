package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.expand.SongExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zyll
 */
@Mapper
public interface SongMapper extends BaseMapper<Song> {
    /**
     * 获取所有的歌曲(默认排序)
     * @return
     */
    List<SongExpand> getSongsById();

    /**
     * 获取所有歌曲(根据受欢迎度排序)
     * @return
     */
    List<SongExpand> getSongsByLike();

    /**
     * 获取所有歌曲(根据播放量排序)
     * @return
     */
    List<SongExpand> getSongsByPlay();
    /**
     * 根据类型id查询歌曲
     * @param typeid
     * @return
     */
    List<SongExpand> getSongsByType(Integer typeid);

    /**
     * 根据id来查询歌曲
     * @param id
     * @return
     */
    SongExpand getSongById(Integer id);

    /**
     * 根据歌手id来查询歌曲
     * @param singerid
     * @return
     */
    List<SongExpand> getSongsBySinger(Integer singerid);

    /**
     * 根据歌单id来查询歌曲
     * @param songlistid
     * @return
     */
    List<SongExpand> getSongsBySongList(Integer songlistid);

    /**
     * 根据歌曲名称模糊查询
     * @param songname
     * @return
    List<SongExpand> getSongsLikeName(String songname);
    */
}