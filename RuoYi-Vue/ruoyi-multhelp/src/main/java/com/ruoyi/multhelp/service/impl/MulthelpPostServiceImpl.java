package com.ruoyi.multhelp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.multhelp.mapper.MulthelpPostMapper;
import com.ruoyi.multhelp.domain.MulthelpPost;
import com.ruoyi.multhelp.service.IMulthelpPostService;

/**
 * 发布帮助Service业务层处理
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@Service
public class MulthelpPostServiceImpl implements IMulthelpPostService 
{
    @Autowired
    private MulthelpPostMapper multhelpPostMapper;

    /**
     * 查询发布帮助
     * 
     * @param postid 发布帮助ID
     * @return 发布帮助
     */
    @Override
    public MulthelpPost selectMulthelpPostById(Integer postid)
    {
        return multhelpPostMapper.selectMulthelpPostById(postid);
    }

    /**
     * 查询发布帮助列表
     * 
     * @param multhelpPost 发布帮助
     * @return 发布帮助
     */
    @Override
    public List<MulthelpPost> selectMulthelpPostList(MulthelpPost multhelpPost)
    {
        return multhelpPostMapper.selectMulthelpPostList(multhelpPost);
    }

    /**
     * 新增发布帮助
     * 
     * @param multhelpPost 发布帮助
     * @return 结果
     */
    @Override
    public int insertMulthelpPost(MulthelpPost multhelpPost)
    {
        multhelpPost.setCreateTime(DateUtils.getNowDate());
        return multhelpPostMapper.insertMulthelpPost(multhelpPost);
    }

    /**
     * 修改发布帮助
     * 
     * @param multhelpPost 发布帮助
     * @return 结果
     */
    @Override
    public int updateMulthelpPost(MulthelpPost multhelpPost)
    {
        return multhelpPostMapper.updateMulthelpPost(multhelpPost);
    }

    /**
     * 批量删除发布帮助
     * 
     * @param postids 需要删除的发布帮助ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpPostByIds(Integer[] postids)
    {
        return multhelpPostMapper.deleteMulthelpPostByIds(postids);
    }

    /**
     * 删除发布帮助信息
     * 
     * @param postid 发布帮助ID
     * @return 结果
     */
    @Override
    public int deleteMulthelpPostById(Integer postid)
    {
        return multhelpPostMapper.deleteMulthelpPostById(postid);
    }
}
