package cn.emptyspirit.entity.expand;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.User;
import lombok.Data;
import lombok.ToString;

/**
 * 评论类的扩展类，用了封装关联查询的结果
 */
@Data
@ToString
public class CommentExpand extends Comment {

    /**
     * 评论的回复数量
     */
    private Integer replyNum;


    /**
     * 发布此评论的用户
     */
    private User sendUser;

    /**
     * 被回复的用户
     */
    private User parentUser;

}
