package com.ruoyi.multhelp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ruoyi.multhelp.domain.MiniappContent;

@Mapper
public interface MiniappContentMapper {
    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    String getContentid();

    @Insert("INSERT INTO `multhelp_content` (`send_openid`, `receive_openid`, `sender` ,`content`)"
            + " VALUES (#{send_openid}, #{receive_openid}, #{sender} ,#{content}); ")
    void insertContent(@Param("send_openid") String send_openid, @Param("receive_openid") String receive_openid,
            @Param("sender") String sender, @Param("content") String content);

    @Select("SELECT * FROM `multhelp_content` WHERE `contentid`=#{contentid} ")
    MiniappContent getContent(@Param("contentid") String contentid);

    @Update("UPDATE `multhelp_content` SET `is_read` = '1' WHERE `contentid` = #{contentid};")
    void isRead(@Param("contentid") String contentid);

    @Select("SELECT COUNT(*) FROM `multhelp_content` WHERE `send_openid`= #{otherOpenid}"
            + " AND `receive_openid` = #{myOpenid} AND `is_read`=FALSE")
    String countUnread(@Param("muOpenid") String myOpenid, @Param("otherOpenid") String otherOpenid);
}
