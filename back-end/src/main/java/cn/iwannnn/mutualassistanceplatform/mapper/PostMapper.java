package cn.iwannnn.mutualassistanceplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PostMapper {

    @Insert("INSERT INTO `post` (`postid`) VALUES (NULL); ")
    public void createLine();

    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    public String getPostid();

    @Update("UPDATE `post` SET ${updatedColumn} = #{updatedInfo} WHERE `postid` = #{postid};")
    public void updatePost(String updatedColumn, String updatedInfo, String postid);
}
