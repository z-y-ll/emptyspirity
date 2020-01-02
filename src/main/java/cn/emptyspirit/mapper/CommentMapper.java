package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.expand.CommentExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zyll
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 查询歌曲对应的一级评论
     * @param songId
     * @return
     * @throws Exception
     */
    List<CommentExpand> selectCommentsBySongId(Integer songId) throws Exception;


    /**
     * 查询评论对应的回复
     * @param commentId
     * @return
     */
    List<CommentExpand> selectReplyByCommentId(Integer commentId) throws Exception;


    /**
     * 根据id查询没有被删除的评论
     * @param commentId
     * @return
     * @throws Exception
     */
    @Select("select * from t_comment where id = #{commentId} and comment_del = 0")
    Comment selectUnDelCommentById(Integer commentId) throws Exception;


    /**
     * 将一条评论标记为删除
     * @param commentId
     * @return
     */
    @Update("update t_comment set comment_del = 1 where id = #{commentId}")
    Integer updateCommentToDel(Integer commentId) throws Exception;

}