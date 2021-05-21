package cn.iwannnn.miniapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.iwannnn.miniapp.dto.PostMini;

@Mapper
public interface SearchMapper {

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`=TRUE AND MATCH (`tittle`,`detail`,`address`) AGAINST (#{searchValue}) LIMIT #{nums};")
    List<PostMini> search(String searchValue, int nums);
}
