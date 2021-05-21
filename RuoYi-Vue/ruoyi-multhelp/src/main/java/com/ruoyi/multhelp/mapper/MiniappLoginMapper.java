package com.ruoyi.multhelp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.multhelp.domain.MiniappLogin;

@Mapper
public interface MiniappLoginMapper {
    @Insert("INSERT INTO `multhelp_login` (`session_3rd`, `openid`, `session_key`) VALUES (#{session_3rd}, #{openid} , #{session_key}); ")
    void login(@Param("session_3rd") String session_3rd, @Param("openid") String openid,
            @Param("session_key") String session_key);

    @Select("SELECT * FROM `multhelp_login` WHERE `session_3rd`= #{session_3rd}")
    MiniappLogin getLoginInfo(@Param("session_3rd") String session_3rd);
}
