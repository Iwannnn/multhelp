package cn.iwannnn.mutualassistanceplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;

public interface ChatMapper {

    @Insert("INSERT INTO `chat` (`initiator_openid`, `invitee_openid` ) VALUES ( #{initiator_openid} , #{invitee_openid} ); ")
    void createChat(String initiator_openid, String invitee_openid);

    @Select("SELECT * FROM `chat` WHERE (( `initiator_openid` = #{initiator_openid} AND `invitee_openid` =#{invitee_openid} ) OR"
            + " ( `initiator_openid` = #{invitee_openid} AND `invitee_openid` = #{initiator_openid} )) ")
    Chat checkChat(String initiator_openid, String invitee_openid);

    @Select("SELECT * FROM `chat` WHERE `chatid` = #{chatid}")
    Chat getChat(String chatid);

    @Select("SELECT ${selectedColumn} FROM `chat` WHERE `chatid` = #{chatid};")
    String selectFromChat(String selectedColumn, String chatid);
}
