package com.ruoyi.multhelp.mapper;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpAccount;

/**
 * 用户账号Mapper接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface MulthelpAccountMapper 
{
    /**
     * 查询用户账号
     * 
     * @param openid 用户账号ID
     * @return 用户账号
     */
    public MulthelpAccount selectMulthelpAccountById(String openid);

    /**
     * 查询用户账号列表
     * 
     * @param multhelpAccount 用户账号
     * @return 用户账号集合
     */
    public List<MulthelpAccount> selectMulthelpAccountList(MulthelpAccount multhelpAccount);

    /**
     * 新增用户账号
     * 
     * @param multhelpAccount 用户账号
     * @return 结果
     */
    public int insertMulthelpAccount(MulthelpAccount multhelpAccount);

    /**
     * 修改用户账号
     * 
     * @param multhelpAccount 用户账号
     * @return 结果
     */
    public int updateMulthelpAccount(MulthelpAccount multhelpAccount);

    /**
     * 删除用户账号
     * 
     * @param openid 用户账号ID
     * @return 结果
     */
    public int deleteMulthelpAccountById(String openid);

    /**
     * 批量删除用户账号
     * 
     * @param openids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMulthelpAccountByIds(String[] openids);
}
