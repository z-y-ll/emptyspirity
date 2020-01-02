package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.SongList;
import cn.emptyspirit.entity.expand.SongListExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zyll
 */
@Mapper
public interface SongListMapper extends BaseMapper<SongList> {
    /**
     * 获取歌单的详细信息
     * @param songListId
     * @return
     */
    SongListExpand selectSongListById(Integer songListId) throws Exception;

    /**
     * 获取全部歌单信息
     * @return
     * @throws Exception
     */
    List<SongListExpand> getSongLists() throws Exception;
}