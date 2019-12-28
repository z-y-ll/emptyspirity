package cn.emptyspirit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Type {
    /**
     id
     * 自增主键
     */
    private Integer id;

    /**
     * name
     * 歌曲类型名
     */
    private String name;
}