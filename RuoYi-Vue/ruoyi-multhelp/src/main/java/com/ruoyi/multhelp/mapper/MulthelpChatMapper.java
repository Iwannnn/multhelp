package com.ruoyi.multhelp.mapper;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpChat;

/**
 * 用户聊天Mapper接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface MulthelpChatMapper 
{
    /**
     * 查询用户聊天
     * 
     * @param chatid 用户聊天ID
     * @return 用户聊天
     */
    public MulthelpChat selectMulthelpChatById(Long chatid);

    /**
     * 查询用户聊天列表
     * 
     * @param multhelpChat 用户聊天
     * @return 用户聊天集合
     */
    public List<MulthelpChat> selectMulthelpChatList(MulthelpChat multhelpChat);

    /**
     * 新增用户聊天
     * 
     * @param multhelpChat 用户聊天
     * @return 结果
     */
    public int insertMulthelpChat(MulthelpChat multhelpChat);

    /**
     * 修改用户聊天
     * 
     * @param multhelpChat 用户聊天
     * @return 结果
     */
    public int updateMulthelpChat(MulthelpChat multhelpChat);

    /**
     * 删除用户聊天
     * 
     * @param chatid 用户聊天ID
     * @return 结果
     */
    public int deleteMulthelpChatById(Long chatid);

    /**
     * 批量删除用户聊天
     * 
     * @param chatids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMulthelpChatByIds(Long[] chatids);
}
