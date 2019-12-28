package cn.emptyspirit.mapper;

import cn.emptyspirit.entity.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询未被封禁的用户
     * @param username
     * @returns
     */
    @Select("select id, user_name, `password`, avatar from t_user " +
            "where user_name = #{username} and user_status = 0 and user_type = 0")
    List<User> selectUserByName(@Param("username") String username) throws Exception;


    /**
     * 通过用户id，查询未封禁的普通用户
     * @param id
     * @return
     */
    @Select("select id, user_name, `password`, avatar from t_user where id = #{id} " +
            "and user_status = 0 and user_type = 0")
    User selectUnbannedUserById(Integer id);
}