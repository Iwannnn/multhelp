package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

public interface PostMapper {

    @Insert("INSERT INTO `post` (`postid`) VALUES (NULL); ")
    public void createLine();

    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    public String getPostid();

    @Update("UPDATE `post` SET ${updatedColumn} = #{updatedInfo} WHERE `postid` = #{postid};")
    public void updatePost(String updatedColumn, String updatedInfo, String postid);

    @Select("SELECT * FROM `post` order by `postid` limit #{nums}")
    public List<PostMini> getPosts(int nums);
}
