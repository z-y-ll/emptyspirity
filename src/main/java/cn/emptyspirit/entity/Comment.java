package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Date createTime;

    /**
     * root_id
     * 此评论所属的根评论id，若此评论为一级评论，则此属性为0
     */
    private Integer rootId;

}