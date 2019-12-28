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