package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Comment;
import cn.emptyspirit.entity.User;
import cn.emptyspirit.entity.expand.CommentExpand;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.CommentServcie;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论模块
 */
@RestController
@RequestMapping("/comment")
@CrossOrigin
@Api(value = "评论模块", tags = "评论模块相关的接口")
public class CommentController {

    private CommentServcie commentServcie;

    @Autowired
    public CommentController(CommentServcie commentServcie) {
        this.commentServcie = commentServcie;
    }

    /**
     * 用户创建一条新评论
     * @param comment 评论的相关消息
     * @return
     * @throws Exception
     */
    @PostMapping("/createComment")
    public R createComment(Comment comment /*HttpSession session*/) throws Exception{
//        User user = (User) session.getAttribute("user");
        return commentServcie.insertNewComment(comment, comment.getUserId()) > 0
                ? R.ok("评论成功") : R.error("评论失败");
    }


    /**
     * 获取歌曲的全部一级评论
     * @param songId 歌曲id
     * @return
     * @throws Exception
     */
    @GetMapping("/getSongComments/{songId}")
    public R getSongComments(@PathVariable("songId") Integer songId)throws Exception {
        List<CommentExpand> comments = commentServcie.selectSongComments(songId);
        if (comments == null || comments.isEmpty()) {
            return R.no("评论为空");
        }
        return R.ok(comments);
    }


    /**
     * 获取评论的回复
     * @param commentId 评论id
     * @return
     */
    @GetMapping("/getReplyByCommentId/{commentId}")
    public R getReplyByCommentId(@PathVariable("commentId") Integer commentId) throws Exception{
        List<CommentExpand> comments = commentServcie.selectReplyByCommentId(commentId);
        if (comments == null || comments.isEmpty()) {
            return R.no("回复为空");
        }
        return R.ok(comments);
    }


    /**
     * 删除一条评论
     * @param commentId 评论id
     * @return
     */
    @PostMapping("deleteComment")
    public R deleteComment(Integer commentId) throws Exception {
        return commentServcie.deleteComment(commentId) > 0 ? R.ok("删除成功") : R.error("删除失败");
    }
}
