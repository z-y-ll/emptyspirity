package cn.emptyspirit.entity.expand;

import cn.emptyspirit.entity.SongList;
import lombok.*;

/**
 * songList类的扩展类，用来记录关联查询的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SongListExpand extends SongList {
    /**
     * 歌单中歌曲的数目
     */
    private Integer songNum;
}
