package cn.emptyspirit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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