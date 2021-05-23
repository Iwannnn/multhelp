package com.ruoyi.miniapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.miniapp.domain.MiniappChat;

@Mapper
public interface MiniappChatMapper {

    @Insert("INSERT INTO `multhelp_chat` (`initiator_openid`, `invitee_openid` ) VALUES ( #{initiator_openid} , #{invitee_openid} ); ")
    void createChat(@Param("initiator_openid") String initiator_openid, @Param("invitee_openid") String invitee_openid);

    @Select("SELECT * FROM `multhelp_chat` WHERE (( `initiator_openid` = #{initiator_openid} AND `invitee_openid` =#{invitee_openid} ) OR"
            + " ( `initiator_openid` = #{invitee_openid} AND `invitee_openid` = #{initiator_openid} )) ")
    MiniappChat checkChat(@Param("initiator_openid") String initiator_openid,
            @Param("invitee_openid") String invitee_openid);

    @Select("SELECT * FROM `multhelp_chat` WHERE `chatid` = #{chatid}")
    MiniappChat getChat(@Param("chatid") String chatid);

    @Select("SELECT ${selectedColumn} FROM `multhelp_chat` WHERE `chatid` = #{chatid};")
    String selectFromChat(@Param("selectedColumn") String selectedColumn, @Param("chatid") String chatid);

    @Select("SELECT `chatid` FROM `multhelp_chat` WHERE `initiator_openid`= #{openid}  OR `invitee_openid`= #{openid}")
    List<String> getChats(@Param("openid") String openid);
}
