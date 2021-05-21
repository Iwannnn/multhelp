package com.ruoyi.multhelp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ruoyi.multhelp.dto.MiniappPostDetail;
import com.ruoyi.multhelp.dto.MiniappPostMini;

@Mapper
public interface MiniappPostMapper {

    @Insert("INSERT INTO `multhelp_post` (`postid`) VALUES (NULL); ")
    public void createLine();

    @Update("UPDATE `post` SET ${updatedColumn} = #{updatedInfo} WHERE `multhelp_postid` = #{postid};")
    public void updatePost(@Param("updatedColumn") String updatedColumn, @Param("updatedInfo") String updatedInfo,
            @Param("postid") String postid);

    @Update("UPDATE `post` SET `is_value` = #{isValue} WHERE `multhelp_postid` = #{postid};")
    public void updateValue(@Param("isValue") Boolean isValue, @Param("postid") String postid);

    @Select("SELECT LAST_INSERT_ID();") // 获取最近一次自增的主键
    public String getPostid();

    @Select("SELECT ${selectedColumn} FROM `multhelp_post` WHERE `postid` = #{postid};")
    String selectFromPost(@Param("selectedColumn") String selectedColumn, @Param("postid") String postid);

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`= TRUE ORDER BY `postid` DESC LIMIT #{nums}")
    public List<MiniappPostMini> getPostsWithoutCategory(@Param("nums") int nums);

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`= TRUE AND `category`=#{category} ORDER BY `postid` DESC LIMIT #{nums}")
    public List<MiniappPostMini> getPostsWithCategory(@Param("category") String category, @Param("nums") int nums);

    @Select("SELECT * FROM `multhelp_post`  INNER JOIN `multhelp_account` WHERE `openid`= #{openid} AND `postid` = #{postid}; ")
    public MiniappPostDetail getPostDetail(@Param("openid") String openid, @Param("postid") String postid);

    @Select("SELECT `is_value` FROM `multhelp_post` WHERE `postid` = #{postid};")
    public boolean isValue(@Param("postid") String postid);
}
