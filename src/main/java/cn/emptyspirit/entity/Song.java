package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_song")
public class Song {
    /**
     * id
     * 自增id
     */
    private Integer id;

    /**
     * song_name
     * 歌曲名称
     */
    private String songName;

    /**
     * song_url
     * 歌曲路径
     */
    private String songUrl;

    /**
     * play_time
     * 时长
     */
    private Long playTime;

    /**
     * song_word
     * 歌词
     */
    private String songWord;

    /**
     * song_photo
     * 歌曲图片路径
     */
    private String songPhoto;

    /**
     * song_type
     * 歌曲类型的id
     */
    private Integer songType;

    /**
     * play_number
     * 播放量
     */
    private Integer playNumber;

    /**
     * like_number
     * 收藏量
     */
    private Integer likeNumber;

    /**
     * singer_id
     * 歌曲id
     */
    private Integer singerId;

}