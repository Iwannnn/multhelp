package com.ruoyi.multhelp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpMessageMapper;
import com.ruoyi.multhelp.domain.MulthelpMessage;
import com.ruoyi.multhelp.service.IMulthelpMessageService;

/**
 * 消息界面Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpMessageServiceImpl implements IMulthelpMessageService 
{
    @Autowired
    private MulthelpMessageMapper multhelpMessageMapper;

    /**
     * 查询消息界面
     * 
     * @param chatid 消息界面ID
     * @return 消息界面
     */
    @Override
    public MulthelpMessage selectMulthelpMessageById(Long chatid)
    {
        return multhelpMessageMapper.selectMulthelpMessageById(chatid);
    }

    /**
     * 查询消息界面列表
     * 
     * @param multhelpMessage 消息界面
     * @return 消息界面
     */
    @Override
    public List<MulthelpMessage> selectMulthelpMessageList(MulthelpMessage multhelpMessage)
    {
        return multhelpMessageMapper.selectMulthelpMessageList(multhelpMessage);
    }

    /**
     * 新增消息界面
     * 
     * @param multhelpMessage 消息界面
     * @return 结果
     */
    @Override
    public int insertMulthelpMessage(MulthelpMessage multhelpMessage)
    {
        return multhelpMessageMapper.insertMulthelpMessage(multhelpMessage);
    }

    /**
     * 修改消息界面
     * 
     * @param multhelpMessage 消息界面
     * @return 结果
     */
    @Override
    public int updateMulthelpMessage(MulthelpMessage multhelpMessage)
    {
        return multhelpMessageMapper.updateMulthelpMessage(multhelpMessage);
    }

    /**
     * 批量删除消息界面
     * 
     * @param chatids 需要删除的消息界面ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpMessageByIds(Long[] chatids)
    {
        return multhelpMessageMapper.deleteMulthelpMessageByIds(chatids);
    }

    /**
     * 删除消息界面信息
     * 
     * @param chatid 消息界面ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpMessageById(Long chatid)
    {
        return multhelpMessageMapper.deleteMulthelpMessageById(chatid);
    }
}
