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
@TableName("t_user_singer")
public class UserAndSinger {
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
     * singer_id
     * 歌手id
     */
    private Integer singerId;
}