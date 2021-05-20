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
import com.ruoyi.multhelp.domain.MulthelpContent;
import com.ruoyi.multhelp.service.IMulthelpContentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聊天内容Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/content")
public class MulthelpContentController extends BaseController
{
    @Autowired
    private IMulthelpContentService multhelpContentService;

    /**
     * 查询聊天内容列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpContent multhelpContent)
    {
        startPage();
        List<MulthelpContent> list = multhelpContentService.selectMulthelpContentList(multhelpContent);
        return getDataTable(list);
    }

    /**
     * 导出聊天内容列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:export')")
    @Log(title = "聊天内容", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpContent multhelpContent)
    {
        List<MulthelpContent> list = multhelpContentService.selectMulthelpContentList(multhelpContent);
        ExcelUtil<MulthelpContent> util = new ExcelUtil<MulthelpContent>(MulthelpContent.class);
        return util.exportExcel(list, "聊天内容数据");
    }

    /**
     * 获取聊天内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:query')")
    @GetMapping(value = "/{contentid}")
    public AjaxResult getInfo(@PathVariable("contentid") Long contentid)
    {
        return AjaxResult.success(multhelpContentService.selectMulthelpContentById(contentid));
    }

    /**
     * 新增聊天内容
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:add')")
    @Log(title = "聊天内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpContent multhelpContent)
    {
        return toAjax(multhelpContentService.insertMulthelpContent(multhelpContent));
    }

    /**
     * 修改聊天内容
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:edit')")
    @Log(title = "聊天内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpContent multhelpContent)
    {
        return toAjax(multhelpContentService.updateMulthelpContent(multhelpContent));
    }

    /**
     * 删除聊天内容
     */
    @PreAuthorize("@ss.hasPermi('multhelp:content:remove')")
    @Log(title = "聊天内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contentids}")
    public AjaxResult remove(@PathVariable Long[] contentids)
    {
        return toAjax(multhelpContentService.deleteMulthelpContentByIds(contentids));
    }
}
