package cn.iwannnn.miniapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.miniapp.pojo.Content;

@Mapper
public interface ContentMapper {
    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    String getContentid();

    @Insert("INSERT INTO `multhelp_content` (`send_openid`, `receive_openid`, `sender` ,`content`)"
            + " VALUES (#{send_openid}, #{receive_openid}, #{sender} ,#{content}); ")
    void insertContent(String send_openid, String receive_openid, String sender, String content);

    @Select("SELECT * FROM `multhelp_content` WHERE `contentid`=#{contentid} ")
    Content getContent(String contentid);

    @Update("UPDATE `multhelp_content` SET `is_read` = '1' WHERE `contentid` = #{contentid};")
    void isRead(String contentid);

    @Select("SELECT COUNT(*) FROM `multhelp_content` WHERE `send_openid`= #{otherOpenid}"
            + " AND `receive_openid` = #{myOpenid} AND `is_read`=FALSE")
    String countUnread(String myOpenid, String otherOpenid);
}
