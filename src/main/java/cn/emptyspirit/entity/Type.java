package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName("t_type")
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