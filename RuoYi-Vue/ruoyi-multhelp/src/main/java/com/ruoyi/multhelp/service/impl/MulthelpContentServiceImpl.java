package com.ruoyi.multhelp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpContentMapper;
import com.ruoyi.multhelp.domain.MulthelpContent;
import com.ruoyi.multhelp.service.IMulthelpContentService;

/**
 * 聊天内容Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpContentServiceImpl implements IMulthelpContentService 
{
    @Autowired
    private MulthelpContentMapper multhelpContentMapper;

    /**
     * 查询聊天内容
     * 
     * @param contentid 聊天内容ID
     * @return 聊天内容
     */
    @Override
    public MulthelpContent selectMulthelpContentById(Long contentid)
    {
        return multhelpContentMapper.selectMulthelpContentById(contentid);
    }

    /**
     * 查询聊天内容列表
     * 
     * @param multhelpContent 聊天内容
     * @return 聊天内容
     */
    @Override
    public List<MulthelpContent> selectMulthelpContentList(MulthelpContent multhelpContent)
    {
        return multhelpContentMapper.selectMulthelpContentList(multhelpContent);
    }

    /**
     * 新增聊天内容
     * 
     * @param multhelpContent 聊天内容
     * @return 结果
     */
    @Override
    public int insertMulthelpContent(MulthelpContent multhelpContent)
    {
        multhelpContent.setCreateTime(DateUtils.getNowDate());
        return multhelpContentMapper.insertMulthelpContent(multhelpContent);
    }

    /**
     * 修改聊天内容
     * 
     * @param multhelpContent 聊天内容
     * @return 结果
     */
    @Override
    public int updateMulthelpContent(MulthelpContent multhelpContent)
    {
        return multhelpContentMapper.updateMulthelpContent(multhelpContent);
    }

    /**
     * 批量删除聊天内容
     * 
     * @param contentids 需要删除的聊天内容ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpContentByIds(Long[] contentids)
    {
        return multhelpContentMapper.deleteMulthelpContentByIds(contentids);
    }

    /**
     * 删除聊天内容信息
     * 
     * @param contentid 聊天内容ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpContentById(Long contentid)
    {
        return multhelpContentMapper.deleteMulthelpContentById(contentid);
    }
}
