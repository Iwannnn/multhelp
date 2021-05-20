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
import com.ruoyi.multhelp.domain.MulthelpMessage;
import com.ruoyi.multhelp.service.IMulthelpMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息界面Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/message")
public class MulthelpMessageController extends BaseController
{
    @Autowired
    private IMulthelpMessageService multhelpMessageService;

    /**
     * 查询消息界面列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpMessage multhelpMessage)
    {
        startPage();
        List<MulthelpMessage> list = multhelpMessageService.selectMulthelpMessageList(multhelpMessage);
        return getDataTable(list);
    }

    /**
     * 导出消息界面列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:export')")
    @Log(title = "消息界面", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpMessage multhelpMessage)
    {
        List<MulthelpMessage> list = multhelpMessageService.selectMulthelpMessageList(multhelpMessage);
        ExcelUtil<MulthelpMessage> util = new ExcelUtil<MulthelpMessage>(MulthelpMessage.class);
        return util.exportExcel(list, "消息界面数据");
    }

    /**
     * 获取消息界面详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:query')")
    @GetMapping(value = "/{chatid}")
    public AjaxResult getInfo(@PathVariable("chatid") Long chatid)
    {
        return AjaxResult.success(multhelpMessageService.selectMulthelpMessageById(chatid));
    }

    /**
     * 新增消息界面
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:add')")
    @Log(title = "消息界面", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpMessage multhelpMessage)
    {
        return toAjax(multhelpMessageService.insertMulthelpMessage(multhelpMessage));
    }

    /**
     * 修改消息界面
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:edit')")
    @Log(title = "消息界面", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpMessage multhelpMessage)
    {
        return toAjax(multhelpMessageService.updateMulthelpMessage(multhelpMessage));
    }

    /**
     * 删除消息界面
     */
    @PreAuthorize("@ss.hasPermi('multhelp:message:remove')")
    @Log(title = "消息界面", businessType = BusinessType.DELETE)
	@DeleteMapping("/{chatids}")
    public AjaxResult remove(@PathVariable Long[] chatids)
    {
        return toAjax(multhelpMessageService.deleteMulthelpMessageByIds(chatids));
    }
}
