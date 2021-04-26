package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.entity.MyPost;

public interface MyMapper {
    @Select("SELECT * FROM `post` WHERE ${selectedColumn} = #{selectedInfo} ORDER BY `postid` DESC LIMIT #{nums}")
    List<MyPost> getPosts(String selectedColumn, String selectedInfo, int nums);

    @Select("SELECT * FROM `post` WHERE `postid` = #{postid}")
    MyPost getPostDetail(String postid);

    @Select("SELECT ${selectedColumn} FROM `post` WHERE `postid` = #{postid};")
    String selectFromPost(String selectedColumn, String postid);

}
