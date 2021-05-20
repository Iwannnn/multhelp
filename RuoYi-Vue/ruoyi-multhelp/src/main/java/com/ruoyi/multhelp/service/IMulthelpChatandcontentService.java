package com.ruoyi.multhelp.service;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpChatandcontent;

/**
 * 聊天会话连接Service接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface IMulthelpChatandcontentService 
{
    /**
     * 查询聊天会话连接
     * 
     * @param chatid 聊天会话连接ID
     * @return 聊天会话连接
     */
    public MulthelpChatandcontent selectMulthelpChatandcontentById(Long chatid);

    /**
     * 查询聊天会话连接列表
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 聊天会话连接集合
     */
    public List<MulthelpChatandcontent> selectMulthelpChatandcontentList(MulthelpChatandcontent multhelpChatandcontent);

    /**
     * 新增聊天会话连接
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 结果
     */
    public int insertMulthelpChatandcontent(MulthelpChatandcontent multhelpChatandcontent);

    /**
     * 修改聊天会话连接
     * 
     * @param multhelpChatandcontent 聊天会话连接
     * @return 结果
     */
    public int updateMulthelpChatandcontent(MulthelpChatandcontent multhelpChatandcontent);

    /**
     * 批量删除聊天会话连接
     * 
     * @param chatids 需要删除的聊天会话连接ID
     * @return 结果
     */
    public int deleteMulthelpChatandcontentByIds(Long[] chatids);

    /**
     * 删除聊天会话连接信息
     * 
     * @param chatid 聊天会话连接ID
     * @return 结果
     */
    public int deleteMulthelpChatandcontentById(Long chatid);
}
