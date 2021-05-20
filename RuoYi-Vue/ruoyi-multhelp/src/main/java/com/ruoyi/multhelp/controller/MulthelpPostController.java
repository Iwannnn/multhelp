package com.ruoyi.multhelp.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.multhelp.domain.MulthelpPost;
import com.ruoyi.multhelp.service.IMulthelpPostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发布帮助Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/post")
public class MulthelpPostController extends BaseController
{
    @Autowired
    private IMulthelpPostService multhelpPostService;

    /**
     * 查询发布帮助列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpPost multhelpPost)
    {
        startPage();
        List<MulthelpPost> list = multhelpPostService.selectMulthelpPostList(multhelpPost);
        return getDataTable(list);
    }

    /**
     * 导出发布帮助列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:export')")
    @Log(title = "发布帮助", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpPost multhelpPost)
    {
        List<MulthelpPost> list = multhelpPostService.selectMulthelpPostList(multhelpPost);
        ExcelUtil<MulthelpPost> util = new ExcelUtil<MulthelpPost>(MulthelpPost.class);
        return util.exportExcel(list, "发布帮助数据");
    }

    /**
     * 获取发布帮助详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:query')")
    @GetMapping(value = "/{postid}")
    public AjaxResult getInfo(@PathVariable("postid") Integer postid)
    {
        return AjaxResult.success(multhelpPostService.selectMulthelpPostById(postid));
    }

    /**
     * 新增发布帮助
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:add')")
    @Log(title = "发布帮助", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpPost multhelpPost)
    {
        return toAjax(multhelpPostService.insertMulthelpPost(multhelpPost));
    }

    /**
     * 修改发布帮助
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:edit')")
    @Log(title = "发布帮助", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpPost multhelpPost)
    {
        return toAjax(multhelpPostService.updateMulthelpPost(multhelpPost));
    }

    /**
     * 删除发布帮助
     */
    @PreAuthorize("@ss.hasPermi('multhelp:post:remove')")
    @Log(title = "发布帮助", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postids}")
    public AjaxResult remove(@PathVariable Integer[] postids)
    {
        return toAjax(multhelpPostService.deleteMulthelpPostByIds(postids));
    }
}
