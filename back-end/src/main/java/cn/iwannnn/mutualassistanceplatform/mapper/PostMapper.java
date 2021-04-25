package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.mutualassistanceplatform.entity.PostDetail;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

public interface PostMapper {

    @Insert("INSERT INTO `post` (`postid`) VALUES (NULL); ")
    public void createLine();

    @Update("UPDATE `post` SET ${updatedColumn} = #{updatedInfo} WHERE `postid` = #{postid};")
    public void updatePost(String updatedColumn, String updatedInfo, String postid);

    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    public String getPostid();

    @Select("SELECT ${selectedColumn} FROM `post` WHERE `postid` = #{postid};")
    String selectfromPost(String selectedColumn, String postid);

    @Select("SELECT * FROM `post` WHERE `value`= TRUE order by `postid` limit #{nums}")
    public List<PostMini> getPostsWithoutCategory(int nums);

    @Select("SELECT * FROM `post` WHERE `value`= TRUE AND `category`=#{category} order by `postid` limit #{nums}")
    public List<PostMini> getPostsWithCategory(String category, int nums);

    @Select("SELECT * FROM `post`  INNER JOIN `account` WHERE `openid`= #{openid} AND `postid` = #{postid}; ")
    public PostDetail getPostDetail(String openid, String postid);
}
