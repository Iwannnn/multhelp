package com.ruoyi.multhelp.service;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpContent;

/**
 * 聊天内容Service接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface IMulthelpContentService 
{
    /**
     * 查询聊天内容
     * 
     * @param contentid 聊天内容ID
     * @return 聊天内容
     */
    public MulthelpContent selectMulthelpContentById(Long contentid);

    /**
     * 查询聊天内容列表
     * 
     * @param multhelpContent 聊天内容
     * @return 聊天内容集合
     */
    public List<MulthelpContent> selectMulthelpContentList(MulthelpContent multhelpContent);

    /**
     * 新增聊天内容
     * 
     * @param multhelpContent 聊天内容
     * @return 结果
     */
    public int insertMulthelpContent(MulthelpContent multhelpContent);

    /**
     * 修改聊天内容
     * 
     * @param multhelpContent 聊天内容
     * @return 结果
     */
    public int updateMulthelpContent(MulthelpContent multhelpContent);

    /**
     * 批量删除聊天内容
     * 
     * @param contentids 需要删除的聊天内容ID
     * @return 结果
     */
    public int deleteMulthelpContentByIds(Long[] contentids);

    /**
     * 删除聊天内容信息
     * 
     * @param contentid 聊天内容ID
     * @return 结果
     */
    public int deleteMulthelpContentById(Long contentid);
}
