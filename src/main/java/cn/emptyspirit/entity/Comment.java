package cn.emptyspirit.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Integer id;

    private Integer songId;

    private Integer userId;

    private String content;

    private Date createTime;


}