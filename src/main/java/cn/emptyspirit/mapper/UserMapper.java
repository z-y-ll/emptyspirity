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
     * 根据用户名查询用户
     * @param username
     * @returns
     */
    @Select("select * from t_user where user_name = #{username}")
    List<User> selectUserByName(@Param("username") String username) throws Exception;
}