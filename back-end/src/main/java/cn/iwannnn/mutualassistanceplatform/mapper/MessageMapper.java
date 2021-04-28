package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.entity.Message;

public interface MessageMapper {
    @Insert("INSERT INTO `message` (`chatid`, `contentid`) VALUES (#{chatid}, #{contentid}); ")
    void insertMessage(String chatid, String contentid);

    @Select("SELECT * FROM `message` WHERE `chatid` = #{chatid} ")
    List<Message> getMessages(String chatid);
}
