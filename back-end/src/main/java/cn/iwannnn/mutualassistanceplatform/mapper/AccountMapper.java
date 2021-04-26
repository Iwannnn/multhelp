package cn.iwannnn.mutualassistanceplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iwannnn.mutualassistanceplatform.entity.Account;

public interface AccountMapper {

    @Insert("INSERT IGNORE INTO `account` (`openid`) VALUES (#{openid});")
    void insertOpenid(String openid);

    @Update("UPDATE `account` SET ${updatedColumn} = #{updatedInfo} WHERE `openid` = #{openid};")
    void updateProfile(String updatedColumn, String updatedInfo, String openid);

    @Select("SELECT * FROM `account` WHERE `openid`= #{openid}")
    Account selectProfile(String openid);

    @Select("SELECT ${selectedColumn} FROM `post` WHERE `openid` = #{openid};")
    String selectFromAccount(String selectedColumn, String openid);

}
