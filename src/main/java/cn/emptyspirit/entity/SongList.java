package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_songlist")
public class SongList {
    /**
     * id
     * 自增id
     */
    private Integer id;

    /**
     * songlist_name
     * 歌单名
     */
    private String songlistName;

    /**
     * introduction
     * 歌单介绍
     */
    private String introduction;

    /**
     * like_numbers
     * 歌单收藏量
     */
    private Integer likeNumbers;

    /**
     * 歌单图片路径
     */
    private String imageUrl;

}