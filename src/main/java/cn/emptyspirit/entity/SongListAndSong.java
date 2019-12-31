package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_songlist_song")
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