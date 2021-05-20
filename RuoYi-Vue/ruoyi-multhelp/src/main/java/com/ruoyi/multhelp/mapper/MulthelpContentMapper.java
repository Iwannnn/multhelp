package com.ruoyi.multhelp.mapper;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpContent;

/**
 * 聊天内容Mapper接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface MulthelpContentMapper 
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
     * 删除聊天内容
     * 
     * @param contentid 聊天内容ID
     * @return 结果
     */
    public int deleteMulthelpContentById(Long contentid);

    /**
     * 批量删除聊天内容
     * 
     * @param contentids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMulthelpContentByIds(Long[] contentids);
}
