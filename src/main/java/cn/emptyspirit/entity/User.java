package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_user")
public class User implements Serializable {
    @TableId("id")
    private Integer id;

    private String userName;

    private String password;

    private String avatar;

    private Integer userStatus;

    private Integer userType;

}