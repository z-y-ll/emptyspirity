package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}