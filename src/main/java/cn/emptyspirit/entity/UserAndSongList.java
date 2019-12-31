package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_songlist")
public class UserAndSongList {
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
     * songlist_id
     * 歌单id
     */
    private Integer songlistId;

}