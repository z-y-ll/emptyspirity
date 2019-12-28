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