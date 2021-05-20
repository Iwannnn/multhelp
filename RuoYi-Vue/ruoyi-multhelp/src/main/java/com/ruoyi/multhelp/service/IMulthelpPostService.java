package com.ruoyi.multhelp.service;

import java.util.List;
import com.ruoyi.multhelp.domain.MulthelpPost;

/**
 * 发布帮助Service接口
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public interface IMulthelpPostService 
{
    /**
     * 查询发布帮助
     * 
     * @param postid 发布帮助ID
     * @return 发布帮助
     */
    public MulthelpPost selectMulthelpPostById(Integer postid);

    /**
     * 查询发布帮助列表
     * 
     * @param multhelpPost 发布帮助
     * @return 发布帮助集合
     */
    public List<MulthelpPost> selectMulthelpPostList(MulthelpPost multhelpPost);

    /**
     * 新增发布帮助
     * 
     * @param multhelpPost 发布帮助
     * @return 结果
     */
    public int insertMulthelpPost(MulthelpPost multhelpPost);

    /**
     * 修改发布帮助
     * 
     * @param multhelpPost 发布帮助
     * @return 结果
     */
    public int updateMulthelpPost(MulthelpPost multhelpPost);

    /**
     * 批量删除发布帮助
     * 
     * @param postids 需要删除的发布帮助ID
     * @return 结果
     */
    public int deleteMulthelpPostByIds(Integer[] postids);

    /**
     * 删除发布帮助信息
     * 
     * @param postid 发布帮助ID
     * @return 结果
     */
    public int deleteMulthelpPostById(Integer postid);
}
