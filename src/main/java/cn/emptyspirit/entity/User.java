package cn.emptyspirit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    /**
     * id
     * 自增id
     */
    private Integer id;

    /**
     * user_name
     * 用户名
     */
    private String userName;

    /**
     * password
     * 密码
     */
    private String password;

    /**
      avatar
     * 头像路径
     */
    private String avatar;

    /**
     * user_status
     * 是否被封禁（0未被封禁 1被封禁）
     */
    private Integer userStatus;

    /**
     * user_type
     * 是否为管理员（0为普通用户 1为管理员）
     */
    private Integer userType;

}