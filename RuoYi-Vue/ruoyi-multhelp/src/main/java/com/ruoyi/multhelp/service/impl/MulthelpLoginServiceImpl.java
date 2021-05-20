package com.ruoyi.multhelp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpLoginMapper;
import com.ruoyi.multhelp.domain.MulthelpLogin;
import com.ruoyi.multhelp.service.IMulthelpLoginService;

/**
 * 登陆验证Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpLoginServiceImpl implements IMulthelpLoginService 
{
    @Autowired
    private MulthelpLoginMapper multhelpLoginMapper;

    /**
     * 查询登陆验证
     * 
     * @param session3rd 登陆验证ID
     * @return 登陆验证
     */
    @Override
    public MulthelpLogin selectMulthelpLoginById(String session3rd)
    {
        return multhelpLoginMapper.selectMulthelpLoginById(session3rd);
    }

    /**
     * 查询登陆验证列表
     * 
     * @param multhelpLogin 登陆验证
     * @return 登陆验证
     */
    @Override
    public List<MulthelpLogin> selectMulthelpLoginList(MulthelpLogin multhelpLogin)
    {
        return multhelpLoginMapper.selectMulthelpLoginList(multhelpLogin);
    }

    /**
     * 新增登陆验证
     * 
     * @param multhelpLogin 登陆验证
     * @return 结果
     */
    @Override
    public int insertMulthelpLogin(MulthelpLogin multhelpLogin)
    {
        multhelpLogin.setCreateTime(DateUtils.getNowDate());
        return multhelpLoginMapper.insertMulthelpLogin(multhelpLogin);
    }

    /**
     * 修改登陆验证
     * 
     * @param multhelpLogin 登陆验证
     * @return 结果
     */
    @Override
    public int updateMulthelpLogin(MulthelpLogin multhelpLogin)
    {
        return multhelpLoginMapper.updateMulthelpLogin(multhelpLogin);
    }

    /**
     * 批量删除登陆验证
     * 
     * @param session3rds 需要删除的登陆验证ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpLoginByIds(String[] session3rds)
    {
        return multhelpLoginMapper.deleteMulthelpLoginByIds(session3rds);
    }

    /**
     * 删除登陆验证信息
     * 
     * @param session3rd 登陆验证ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpLoginById(String session3rd)
    {
        return multhelpLoginMapper.deleteMulthelpLoginById(session3rd);
    }
}
