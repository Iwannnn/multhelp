package cn.iwannnn.miniapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.miniapp.domain.Account;

@Mapper
public interface AccountMapper {

    @Insert("INSERT IGNORE INTO `multhelp_account` (`openid`) VALUES (#{openid});")
    void insertOpenid(String openid);

    @Update("UPDATE `multhelp_account` SET ${updatedColumn} = #{updatedInfo} WHERE `openid` = #{openid};")
    void updateProfile(String updatedColumn, String updatedInfo, String openid);

    @Select("SELECT * FROM `multhelp_account` WHERE `openid`= #{openid}")
    Account selectProfile(String openid);

    @Select("SELECT ${selectedColumn} FROM `multhelp_post` WHERE `openid` = #{openid};")
    String selectFromAccount(String selectedColumn, String openid);

}
