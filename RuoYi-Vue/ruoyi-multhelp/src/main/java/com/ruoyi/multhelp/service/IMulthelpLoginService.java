package com.ruoyi.multhelp.service;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpLogin;

/**
 * 登陆验证Service接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface IMulthelpLoginService 
{
    /**
     * 查询登陆验证
     * 
     * @param session3rd 登陆验证ID
     * @return 登陆验证
     */
    public MulthelpLogin selectMulthelpLoginById(String session3rd);

    /**
     * 查询登陆验证列表
     * 
     * @param multhelpLogin 登陆验证
     * @return 登陆验证集合
     */
    public List<MulthelpLogin> selectMulthelpLoginList(MulthelpLogin multhelpLogin);

    /**
     * 新增登陆验证
     * 
     * @param multhelpLogin 登陆验证
     * @return 结果
     */
    public int insertMulthelpLogin(MulthelpLogin multhelpLogin);

    /**
     * 修改登陆验证
     * 
     * @param multhelpLogin 登陆验证
     * @return 结果
     */
    public int updateMulthelpLogin(MulthelpLogin multhelpLogin);

    /**
     * 批量删除登陆验证
     * 
     * @param session3rds 需要删除的登陆验证ID
     * @return 结果
     */
    public int deleteMulthelpLoginByIds(String[] session3rds);

    /**
     * 删除登陆验证信息
     * 
     * @param session3rd 登陆验证ID
     * @return 结果
     */
    public int deleteMulthelpLoginById(String session3rd);
}
