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
import com.ruoyi.multhelp.domain.MulthelpChatandcontent;
import com.ruoyi.multhelp.service.IMulthelpChatandcontentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聊天会话连接Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/chatandcontent")
public class MulthelpChatandcontentController extends BaseController {
    @Autowired
    private IMulthelpChatandcontentService multhelpChatandcontentService;

    /**
     * 查询聊天会话连接列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpChatandcontent multhelpChatandcontent) {
        startPage();
        List<MulthelpChatandcontent> list = multhelpChatandcontentService
                .selectMulthelpChatandcontentList(multhelpChatandcontent);
        return getDataTable(list);
    }

    /**
     * 导出聊天会话连接列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:export')")
    @Log(title = "聊天会话连接", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpChatandcontent multhelpChatandcontent) {
        List<MulthelpChatandcontent> list = multhelpChatandcontentService
                .selectMulthelpChatandcontentList(multhelpChatandcontent);
        ExcelUtil<MulthelpChatandcontent> util = new ExcelUtil<MulthelpChatandcontent>(MulthelpChatandcontent.class);
        return util.exportExcel(list, "聊天会话连接数据");
    }

    /**
     * 获取聊天会话连接详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:query')")
    @GetMapping(value = "/{chatid}")
    public AjaxResult getInfo(@PathVariable("chatid") Long chatid) {
        return AjaxResult.success(multhelpChatandcontentService.selectMulthelpChatandcontentById(chatid));
    }

    /**
     * 新增聊天会话连接
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:add')")
    @Log(title = "聊天会话连接", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpChatandcontent multhelpChatandcontent) {
        return toAjax(multhelpChatandcontentService.insertMulthelpChatandcontent(multhelpChatandcontent));
    }

    /**
     * 修改聊天会话连接
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:edit')")
    @Log(title = "聊天会话连接", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpChatandcontent multhelpChatandcontent) {
        return toAjax(multhelpChatandcontentService.updateMulthelpChatandcontent(multhelpChatandcontent));
    }

    /**
     * 删除聊天会话连接
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chatandcontent:remove')")
    @Log(title = "聊天会话连接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{chatids}")
    public AjaxResult remove(@PathVariable Long[] chatids) {
        return toAjax(multhelpChatandcontentService.deleteMulthelpChatandcontentByIds(chatids));
    }
}
