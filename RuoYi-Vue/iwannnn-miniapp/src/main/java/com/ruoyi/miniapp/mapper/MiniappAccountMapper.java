package com.ruoyi.miniapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ruoyi.miniapp.domain.MiniappAccount;

@Mapper
public interface MiniappAccountMapper {

    @Insert("INSERT IGNORE INTO `multhelp_account` (`openid`) VALUES (#{openid});")
    void insertOpenid(@Param("openid") String openid);

    @Update("UPDATE `multhelp_account` SET ${updatedColumn} = #{updatedInfo} WHERE `openid` = #{openid};")
    void updateProfile(@Param("updateColum") String updatedColumn, @Param("updateInfo") String updatedInfo,
            @Param("openid") String openid);

    @Select("SELECT * FROM `multhelp_account` WHERE `openid`= #{openid}")
    MiniappAccount selectProfile(@Param("openid") String openid);

    @Select("SELECT ${selectedColumn} FROM `multhelp_post` WHERE `openid` = #{openid};")
    String selectFromAccount(@Param("selectedColumn") String selectedColumn, @Param("openid") String openid);

}
