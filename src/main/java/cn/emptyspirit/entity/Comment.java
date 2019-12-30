package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName("t_comment")
public class Comment {
    /**
     * id
     * 自增主
     */
    private Integer id;

    /**
     * song_id
     * 歌曲id
     */
    private Integer songId;

    /**
     * user_id
     * 用户id
     */
    private Integer userId;

    /**
     * content
     * 评论内容
     */
    private String content;

    /**
     * create_time
     * 评论时间
     */
    private Date createTime;

}