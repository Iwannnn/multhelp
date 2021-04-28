package cn.iwannnn.mutualassistanceplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.entity.Content;

public interface ContentMapper {
    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    String getContentid();

    @Insert("INSERT INTO `content` (`send_openid`, `receive_openid`, `content`)"
            + " VALUES (#{send_openid}, #{receive_openid}, #{content}); ")
    void insertContent(String send_openid, String receive_openid, String content);

    @Select("SELECT * FROM `content` WHERE `contentid`=#{contentid} ")
    Content getContent(String contentid);
}
