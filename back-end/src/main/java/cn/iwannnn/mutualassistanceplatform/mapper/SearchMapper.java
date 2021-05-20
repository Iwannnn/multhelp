package cn.iwannnn.mutualassistanceplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.iwannnn.mutualassistanceplatform.dto.PostMini;

public interface SearchMapper {

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`=TRUE AND MATCH (`tittle`,`detail`,`address`) AGAINST (#{searchValue}) LIMIT #{nums};")
    List<PostMini> search(String searchValue, int nums);
}
