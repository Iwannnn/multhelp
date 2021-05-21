package com.ruoyi.multhelp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.multhelp.dto.MiniappMyPost;

@Mapper
public interface MiniappMyMapper {
    @Select("SELECT * FROM `multhelp_post` WHERE ${selectedColumn} = #{selectedInfo} ORDER BY `postid` DESC LIMIT #{nums}")
    List<MiniappMyPost> getPosts(@Param("selectedColumn") String selectedColumn,
            @Param("selectedInfo") String selectedInfo, @Param("nums") int nums);

    @Select("SELECT * FROM `multhelp_post` WHERE `postid` = #{postid}")
    MiniappMyPost getPostDetail(@Param("postid") String postid);

    @Select("SELECT ${selectedColumn} FROM `multhelp_post` WHERE `postid` = #{postid};")
    String selectFromPost(@Param("selectedColumn") String selectedColumn, @Param("postid") String postid);

}
