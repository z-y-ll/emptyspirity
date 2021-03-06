package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_singer")
public class Singer implements Serializable {
    /**
     * id
     * 自增id
     */
    private Integer id;

    /**
     * singer_name
     * 歌手名
     */
    private String singerName;

    /**
     * avatar
     * 头像路径
     */
    private String avatar;

    /**
     * gender
     * 性别（0为男，1为女）
     */
    private Integer gender;

    /**
     * age
     * 
     */
    private Integer age;

    /**
     * introduction
     * 歌手介绍
     */
    private String introduction;
}