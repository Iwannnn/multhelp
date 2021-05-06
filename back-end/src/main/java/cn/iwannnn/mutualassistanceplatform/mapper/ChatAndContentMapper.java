package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.entity.ChatAndContent;

public interface ChatAndContentMapper {
    @Insert("INSERT INTO `chatandcontent` (`chatid`, `contentid`) VALUES (#{chatid}, #{contentid}); ")
    void insertMessage(String chatid, String contentid);

    @Select("SELECT * FROM `chatandcontent` WHERE `chatid` = #{chatid} ")
    List<ChatAndContent> getMessages(String chatid);

    @Select("SELECT * FROM `chatandcontent` WHERE `chatid` = #{chatid} ORDER BY `contentid` DESC LIMIT 1 ")
    ChatAndContent getLast(String chatid);
}
