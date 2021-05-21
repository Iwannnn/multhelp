package com.ruoyi.multhelp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.multhelp.domain.MiniappChatAndContent;

@Mapper
public interface MiniappChatAndContentMapper {
    @Insert("INSERT INTO `multhelp_chatandcontent` (`chatid`, `contentid`) VALUES (#{chatid}, #{contentid}); ")
    void insertMessage(@Param("chatid") String chatid, @Param("contentid") String contentid);

    @Select("SELECT * FROM `multhelp_chatandcontent` WHERE `chatid` = #{chatid} ")
    List<MiniappChatAndContent> getMessages(@Param("chatid") String chatid);

    @Select("SELECT * FROM `multhelp_chatandcontent` WHERE `chatid` = #{chatid} ORDER BY `contentid` DESC LIMIT 1 ")
    MiniappChatAndContent getLast(@Param("chatid") String chatid);
}
