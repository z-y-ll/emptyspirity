package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_song")
public class Song {
    @TableId
    private Integer id;

    private String songName;

    private Long playTime;

    private String songWord;

    private String songPhoto;

    private String songType;

    private Integer playNumber;

    private Integer likeNumber;

    private Integer singerId;

}