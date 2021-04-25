package cn.iwannnn.mutualassistanceplatform.mapper;

import org.apache.ibatis.annotations.Select;

public interface SessionMapper {
    @Select("SELECT ${selectedColumn} FROM `login` WHERE `session_3rd`= #{session_3rd}")
    String select(String selectedColumn, String session_3rd);

    @Select("SELECT UNIX_TIMESTAMP(#{create_time})")
    long selectTime(String create_time);
}
