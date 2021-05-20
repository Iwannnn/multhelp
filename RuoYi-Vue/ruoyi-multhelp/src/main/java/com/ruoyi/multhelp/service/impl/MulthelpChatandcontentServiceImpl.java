package com.ruoyi.multhelp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpChatandcontentMapper;
import com.ruoyi.multhelp.domain.MulthelpChatandcontent;
import com.ruoyi.multhelp.service.IMulthelpChatandcontentService;

/**
 * 聊天会话连接Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpChatandcontentServiceImpl implements IMulthelpChatandcontentService 
{
    @Autowired
    private MulthelpChatandcontentMapper multhelpChatandcontentMapper;

    /**
     * 查询聊天会话连接
     * 
     * @param chatid 聊天会话连接ID
     * @return 聊天会话连接
     */
    @Override
    public MulthelpChatandcontent selectMulthelpChatandcontentById(Long chatid)
    {
        return multhelpChatandcontentMapper.selectMulthelpChatandcontentById(chatid);
    }

    /**
     * 查询聊天会话连接列表
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 聊天会话连接
     */
    @Override
    public List<MulthelpChatandcontent> selectMulthelpChatandcontentList(MulthelpChatandcontent multhelpChatandcontent)
    {
        return multhelpChatandcontentMapper.selectMulthelpChatandcontentList(multhelpChatandcontent);
    }

    /**
     * 新增聊天会话连接
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 结果
     */
    @Override
    public int insertMulthelpChatandcontent(MulthelpChatandcontent multhelpChatandcontent)
    {
        return multhelpChatandcontentMapper.insertMulthelpChatandcontent(multhelpChatandcontent);
    }

    /**
     * 修改聊天会话连接
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 结果
     */
    @Override
    public int updateMulthelpChatandcontent(MulthelpChatandcontent multhelpChatandcontent)
    {
        return multhelpChatandcontentMapper.updateMulthelpChatandcontent(multhelpChatandcontent);
    }

    /**
     * 批量删除聊天会话连接
     * 
     * @param chatids 需要删除的聊天会话连接ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpChatandcontentByIds(Long[] chatids)
    {
        return multhelpChatandcontentMapper.deleteMulthelpChatandcontentByIds(chatids);
    }

    /**
     * 删除聊天会话连接信息
     * 
     * @param chatid 聊天会话连接ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpChatandcontentById(Long chatid)
    {
        return multhelpChatandcontentMapper.deleteMulthelpChatandcontentById(chatid);
    }
}
