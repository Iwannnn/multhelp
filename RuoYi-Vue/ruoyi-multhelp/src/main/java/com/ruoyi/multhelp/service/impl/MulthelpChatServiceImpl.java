package com.ruoyi.multhelp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpChatMapper;
import com.ruoyi.multhelp.domain.MulthelpChat;
import com.ruoyi.multhelp.service.IMulthelpChatService;

/**
 * 用户聊天Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpChatServiceImpl implements IMulthelpChatService 
{
    @Autowired
    private MulthelpChatMapper multhelpChatMapper;

    /**
     * 查询用户聊天
     * 
     * @param chatid 用户聊天ID
     * @return 用户聊天
     */
    @Override
    public MulthelpChat selectMulthelpChatById(Long chatid)
    {
        return multhelpChatMapper.selectMulthelpChatById(chatid);
    }

    /**
     * 查询用户聊天列表
     * 
     * @param multhelpChat 用户聊天
     * @return 用户聊天
     */
    @Override
    public List<MulthelpChat> selectMulthelpChatList(MulthelpChat multhelpChat)
    {
        return multhelpChatMapper.selectMulthelpChatList(multhelpChat);
    }

    /**
     * 新增用户聊天
     * 
     * @param multhelpChat 用户聊天
     * @return 结果
     */
    @Override
    public int insertMulthelpChat(MulthelpChat multhelpChat)
    {
        multhelpChat.setCreateTime(DateUtils.getNowDate());
        return multhelpChatMapper.insertMulthelpChat(multhelpChat);
    }

    /**
     * 修改用户聊天
     * 
     * @param multhelpChat 用户聊天
     * @return 结果
     */
    @Override
    public int updateMulthelpChat(MulthelpChat multhelpChat)
    {
        return multhelpChatMapper.updateMulthelpChat(multhelpChat);
    }

    /**
     * 批量删除用户聊天
     * 
     * @param chatids 需要删除的用户聊天ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpChatByIds(Long[] chatids)
    {
        return multhelpChatMapper.deleteMulthelpChatByIds(chatids);
    }

    /**
     * 删除用户聊天信息
     * 
     * @param chatid 用户聊天ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpChatById(Long chatid)
    {
        return multhelpChatMapper.deleteMulthelpChatById(chatid);
    }
}
