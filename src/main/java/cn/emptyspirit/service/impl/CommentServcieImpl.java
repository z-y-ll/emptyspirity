package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.Song;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.expand.CommentExpand;
import cn.emptyspirit.exception.ParamException;
import cn.emptyspirit.mapper.CommentMapper;
import cn.emptyspirit.mapper.SongMapper;
import cn.emptyspirit.mapper.UserMapper;
import cn.emptyspirit.service.CommentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServcieImpl implements CommentServcie {

    private CommentMapper commentMapper;
    private UserMapper userMapper;
    private SongMapper songMapper;

    @Autowired
    public CommentServcieImpl(CommentMapper commentMapper, UserMapper userMapper, SongMapper songMapper) {
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.songMapper = songMapper;
    }


    /**
     * 用户提交一条新评论
     * @param comment 评论实体
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @Override
    public Integer insertNewComment(Comment comment, Integer userId) throws Exception {
        if (comment == null || comment.getContent() == null || "".equals(comment.getContent())
                || comment.getParentId() == null || userId == null) {
            throw new ParamException();
        }

        // 若未接收到rootId，则默认为一级评论
        if (comment.getRootId() == null) {
            comment.setRootId(0);
        }

        // 判断用户是否存在
        User user = userMapper.selectUnbannedUserById(userId);
        if (user == null) {
            throw new ParamException("用户信息异常");
        }

        // 判断parentId
        Integer parentId = comment.getParentId();
        if (comment.getRootId() == 0) {
            // 若为歌曲评论，判断歌曲是否存在
            Song song = songMapper.selectById(parentId);
            if (song == null) {
                throw new ParamException("评论信息异常");
            }
        } else {
            // 若为回复评论，则判断父级评论是否存在
            Comment c = commentMapper.selectUnDelCommentById(parentId);
            if (c == null) {
                throw new ParamException("评论信息异常");
            }
            // 不能回复自己的评论
//            if (userId == c.getUserId()) {
//                throw new ParamException("无法回复自己的评论");
//            }
        }

        // 插入数据库
        comment.setUserId(userId);
        return commentMapper.insert(comment);
    }


    /**
     * 查询歌曲对应的全部一级评论
     * @param songId 歌曲id
     * @return
     */
    @Override
    public List<CommentExpand> selectSongComments(Integer songId) throws Exception {
        if (songId == null) {
            throw new ParamException();
        }

        // 判断歌曲是否存在
        Song song = songMapper.selectById(songId);
        if (song == null) {
            throw new ParamException("歌曲信息异常");
        }

        // 查询
        return commentMapper.selectCommentsBySongId(songId);
    }


    /**
     * 获取评论的回复
     * @param commentId 评论id
     * @return
     * @throws Exception
     */
    @Override
    public List<CommentExpand> selectReplyByCommentId(Integer commentId) throws Exception {
        if (commentId == null) {
            throw new ParamException();
        }

        // 判断评论是否存在，且是否为一级评论
        Comment comment = commentMapper.selectUnDelCommentById(commentId);
        if (comment == null || comment.getRootId() != 0) {
            throw new ParamException("评论信息异常");
        }

        // 查询
        return commentMapper.selectReplyByCommentId(commentId);
    }


    /**
     * 删除一条评论
     * @param commentId 评论id
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteComment(Integer commentId) throws Exception {
        if (commentId == null) {
            throw new ParamException();
        }

        // 判断评论是否存在
        Comment comment = commentMapper.selectUnDelCommentById(commentId);
        if (comment == null ) {
            throw new ParamException("评论信息异常");
        }
        return commentMapper.updateCommentToDel(commentId);
    }

}
