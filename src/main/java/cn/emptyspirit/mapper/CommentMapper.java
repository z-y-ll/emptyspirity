package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.expand.CommentExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
}