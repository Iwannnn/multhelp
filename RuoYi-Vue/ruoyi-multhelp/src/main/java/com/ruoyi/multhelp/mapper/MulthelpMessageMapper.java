package com.ruoyi.multhelp.mapper;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpMessage;

/**
 * 消息界面Mapper接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface MulthelpMessageMapper 
{
    /**
     * 查询消息界面
     * 
     * @param chatid 消息界面ID
     * @return 消息界面
     */
    public MulthelpMessage selectMulthelpMessageById(Long chatid);

    /**
     * 查询消息界面列表
     * 
     * @param multhelpMessage 消息界面
     * @return 消息界面集合
     */
    public List<MulthelpMessage> selectMulthelpMessageList(MulthelpMessage multhelpMessage);

    /**
     * 新增消息界面
     * 
     * @param multhelpMessage 消息界面
     * @return 结果
     */
    public int insertMulthelpMessage(MulthelpMessage multhelpMessage);

    /**
     * 修改消息界面
     * 
     * @param multhelpMessage 消息界面
     * @return 结果
     */
    public int updateMulthelpMessage(MulthelpMessage multhelpMessage);

    /**
     * 删除消息界面
     * 
     * @param chatid 消息界面ID
     * @return 结果
     */
    public int deleteMulthelpMessageById(Long chatid);

    /**
     * 批量删除消息界面
     * 
     * @param chatids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMulthelpMessageByIds(Long[] chatids);
}
