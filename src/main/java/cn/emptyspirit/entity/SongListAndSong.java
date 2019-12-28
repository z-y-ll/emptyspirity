package cn.emptyspirit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SongListAndSong {
    /**
      id
     * 自增id
     */
    private Integer id;

    /**
     * songlist_id
     * 歌单id
     */
    private Integer songlistId;

    /**
     * song_id
     * 歌曲id
     */
    private Integer songId;
}