package com.ruoyi.multhelp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpAccountMapper;
import com.ruoyi.multhelp.domain.MulthelpAccount;
import com.ruoyi.multhelp.service.IMulthelpAccountService;

/**
 * 用户账号Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpAccountServiceImpl implements IMulthelpAccountService 
{
    @Autowired
    private MulthelpAccountMapper multhelpAccountMapper;

    /**
     * 查询用户账号
     * 
     * @param openid 用户账号ID
     * @return 用户账号
     */
    @Override
    public MulthelpAccount selectMulthelpAccountById(String openid)
    {
        return multhelpAccountMapper.selectMulthelpAccountById(openid);
    }

    /**
     * 查询用户账号列表
     * 
     * @param multhelpAccount 用户账号
     * @return 用户账号
     */
    @Override
    public List<MulthelpAccount> selectMulthelpAccountList(MulthelpAccount multhelpAccount)
    {
        return multhelpAccountMapper.selectMulthelpAccountList(multhelpAccount);
    }

    /**
     * 新增用户账号
     * 
     * @param multhelpAccount 用户账号
     * @return 结果
     */
    @Override
    public int insertMulthelpAccount(MulthelpAccount multhelpAccount)
    {
        return multhelpAccountMapper.insertMulthelpAccount(multhelpAccount);
    }

    /**
     * 修改用户账号
     * 
     * @param multhelpAccount 用户账号
     * @return 结果
     */
    @Override
    public int updateMulthelpAccount(MulthelpAccount multhelpAccount)
    {
        return multhelpAccountMapper.updateMulthelpAccount(multhelpAccount);
    }

    /**
     * 批量删除用户账号
     * 
     * @param openids 需要删除的用户账号ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpAccountByIds(String[] openids)
    {
        return multhelpAccountMapper.deleteMulthelpAccountByIds(openids);
    }

    /**
     * 删除用户账号信息
     * 
     * @param openid 用户账号ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpAccountById(String openid)
    {
        return multhelpAccountMapper.deleteMulthelpAccountById(openid);
    }
}
