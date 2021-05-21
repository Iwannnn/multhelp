package cn.iwannnn.miniapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.miniapp.pojo.Login;

@Mapper
public interface LoginMapper {
    @Insert("INSERT INTO `multhelp_login` (`session_3rd`, `openid`, `session_key`) VALUES (#{session_3rd}, #{openid} , #{session_key}); ")
    void login(String session_3rd, String openid, String session_key);

    @Select("SELECT * FROM `multhelp_login` WHERE `session_3rd`= #{session_3rd}")
    Login getLoginInfo(String session_3rd);
}
