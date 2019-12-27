package cn.emptyspirit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Song {
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