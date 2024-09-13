package com.situ.chronicmange.mapper;

import com.situ.chronicmange.entity.Rhr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 档案表 Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
public interface RhrMapper extends BaseMapper<Rhr> {
@Select("select * from rhr where name=#{name}")
    Rhr selectUserByName(String name);
}
