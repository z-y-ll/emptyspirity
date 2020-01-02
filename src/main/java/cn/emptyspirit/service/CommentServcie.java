package cn.emptyspirit.service;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.expand.CommentExpand;
import cn.emptyspirit.global.R;

import java.util.List;

public interface CommentServcie {
    /**
     * 用户提交一条新评论
     * @param comment 评论实体
     * @param userId 用户id
     * @return
     */
    Integer insertNewComment(Comment comment, Integer userId) throws Exception;


    /**
     * 查询歌曲对应的全部一级评论
     * @param songId 歌曲id
     * @return
     */
    List<CommentExpand> selectSongComments(Integer songId) throws Exception;


    /**
     * 获取评论的回复
     * @param commentId
     * @return
     */
    List<CommentExpand> selectReplyByCommentId(Integer commentId) throws Exception;


    /**
     * 删除一条评论
     * @param commentId 评论id
     * @return
     */
    Integer deleteComment(Integer commentId) throws Exception;
}
