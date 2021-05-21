package com.ruoyi.multhelp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MiniappSessionMapper {
    @Select("SELECT ${selectedColumn} FROM `multhelp_login` WHERE `session_3rd`= #{session_3rd}")
    String select(@Param("selectedColumn") String selectedColumn, @Param("session_3rd") String session_3rd);

    @Select("SELECT UNIX_TIMESTAMP(#{create_time})")
    long selectTime(@Param("create_time") String create_time);
}
