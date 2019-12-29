package cn.emptyspirit.entity.expand;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.Type;
import lombok.Data;
import lombok.ToString;

/**
 * song类的扩展类，用来记录关联查询的结果
 */
@Data
@ToString
public class SongExpand extends Song {
    /**
     * 歌曲对应的歌手
     */
    private Singer singer;

    /**
     * 歌曲对应的类型
     */
    private Type type;
}
