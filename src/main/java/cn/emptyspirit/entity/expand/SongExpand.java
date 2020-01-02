package cn.emptyspirit.entity.expand;

import cn.emptyspirit.entity.Singer;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * song类的扩展类，用来记录关联查询的结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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


    /**
     * 歌曲的评论量
     */
    private Integer commentNum;
}
