package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_song")
public class UserAndSong {
    /**
     id
     * 自增id
     */
    private Integer id;

    /**
     * user_id
     * 用户id
     */
    private Integer userId;

    /**
     * song_id
     * 歌曲id
     */
    private Integer songId;
}