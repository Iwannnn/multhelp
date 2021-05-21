package cn.iwannnn.miniapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SessionMapper {
    @Select("SELECT ${selectedColumn} FROM `multhelp_login` WHERE `session_3rd`= #{session_3rd}")
    String select(String selectedColumn, String session_3rd);

    @Select("SELECT UNIX_TIMESTAMP(#{create_time})")
    long selectTime(String create_time);
}
