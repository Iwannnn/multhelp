package com.ruoyi.miniapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ruoyi.miniapp.dto.MiniappPostMini;

@Mapper
public interface MiniappSearchMapper {

    @Select("SELECT * FROM `multhelp_post` WHERE `is_value`=TRUE AND MATCH (`tittle`,`detail`,`address`) AGAINST (#{searchValue}) LIMIT #{nums};")
    List<MiniappPostMini> search(@Param("searchValue") String searchValue, @Param("nums") int nums);
}
