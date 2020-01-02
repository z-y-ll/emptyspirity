package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
     * parent_id
     * 评论所在的歌曲id，或者它父级评论的id
     */
    private Integer parentId;

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;

    /**
     * root_id
     * 此评论所属的根评论id，若此评论为一级评论，则此属性为0
     */
    private Integer rootId;

    /**
     * comment_del
     * 是否被删除，0为没有删，1为删除了
     */
    private Integer commentDel;

}