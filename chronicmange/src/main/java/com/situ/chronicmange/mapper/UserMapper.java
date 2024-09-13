package com.situ.chronicmange.mapper;

import com.situ.chronicmange.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{userName}")
    User selectUserByUserName(String userName);
}
