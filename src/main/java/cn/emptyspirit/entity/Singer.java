package cn.emptyspirit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Singer {
    private Integer id;

    private String singerName;

    private String avatar;

    private Integer gender;

    private Integer age;

    private String introduction;

}