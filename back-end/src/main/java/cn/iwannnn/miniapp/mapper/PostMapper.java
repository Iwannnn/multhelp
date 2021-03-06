package cn.iwannnn.miniapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.miniapp.dto.PostDetail;
import cn.iwannnn.miniapp.dto.PostMini;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO `multhelp_post` (`postid`) VALUES (NULL); ")
    public void createLine();

    @Update("UPDATE `post` SET ${updatedColumn} = #{updatedInfo} WHERE `multhelp_postid` = #{postid};")
    public void updatePost(String updatedColumn, String updatedInfo, String postid);

    @Update("UPDATE `post` SET `is_value` = #{isValue} WHERE `multhelp_postid` = #{postid};")
    public void updateValue(Boolean isValue, String postid);

    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    public String getPostid();

    @Select("SELECT ${selectedColumn} FROM `multhelp_post` WHERE `postid` = #{postid};")
    String selectFromPost(String selectedColumn, String postid);

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`= TRUE ORDER BY `postid` DESC LIMIT #{nums}")
    public List<PostMini> getPostsWithoutCategory(int nums);

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`= TRUE AND `category`=#{category} ORDER BY `postid` DESC LIMIT #{nums}")
    public List<PostMini> getPostsWithCategory(String category, int nums);

    @Select("SELECT * FROM `multhelp_post`  INNER JOIN `account` WHERE `openid`= #{openid} AND `postid` = #{postid}; ")
    public PostDetail getPostDetail(String openid, String postid);

    @Select("SELECT `is_value` FROM `multhelp_post` WHERE `postid` = #{postid};")
    public boolean isValue(String postid);
}
