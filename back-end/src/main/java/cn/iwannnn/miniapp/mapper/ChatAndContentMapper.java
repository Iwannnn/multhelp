package cn.iwannnn.miniapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.miniapp.domain.ChatAndContent;

@Mapper
public interface ChatAndContentMapper {
    @Insert("INSERT INTO `multhelp_chatandcontent` (`chatid`, `contentid`) VALUES (#{chatid}, #{contentid}); ")
    void insertMessage(String chatid, String contentid);

    @Select("SELECT * FROM `multhelp_chatandcontent` WHERE `chatid` = #{chatid} ")
    List<ChatAndContent> getMessages(String chatid);

    @Select("SELECT * FROM `multhelp_chatandcontent` WHERE `chatid` = #{chatid} ORDER BY `contentid` DESC LIMIT 1 ")
    ChatAndContent getLast(String chatid);
}
