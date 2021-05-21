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
import com.ruoyi.multhelp.domain.MulthelpChat;
import com.ruoyi.multhelp.service.IMulthelpChatService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户聊天Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/chat")
public class MulthelpChatController extends BaseController {
    @Autowired
    private IMulthelpChatService multhelpChatService;

    /**
     * 查询用户聊天列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpChat multhelpChat) {
        startPage();
        List<MulthelpChat> list = multhelpChatService.selectMulthelpChatList(multhelpChat);
        return getDataTable(list);
    }

    /**
     * 导出用户聊天列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:export')")
    @Log(title = "用户聊天", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpChat multhelpChat) {
        List<MulthelpChat> list = multhelpChatService.selectMulthelpChatList(multhelpChat);
        ExcelUtil<MulthelpChat> util = new ExcelUtil<MulthelpChat>(MulthelpChat.class);
        return util.exportExcel(list, "用户聊天数据");
    }

    /**
     * 获取用户聊天详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:query')")
    @GetMapping(value = "/{chatid}")
    public AjaxResult getInfo(@PathVariable("chatid") Long chatid) {
        return AjaxResult.success(multhelpChatService.selectMulthelpChatById(chatid));
    }

    /**
     * 新增用户聊天
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:add')")
    @Log(title = "用户聊天", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpChat multhelpChat) {
        return toAjax(multhelpChatService.insertMulthelpChat(multhelpChat));
    }

    /**
     * 修改用户聊天
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:edit')")
    @Log(title = "用户聊天", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpChat multhelpChat) {
        return toAjax(multhelpChatService.updateMulthelpChat(multhelpChat));
    }

    /**
     * 删除用户聊天
     */
    @PreAuthorize("@ss.hasPermi('multhelp:chat:remove')")
    @Log(title = "用户聊天", businessType = BusinessType.DELETE)
    @DeleteMapping("/{chatids}")
    public AjaxResult remove(@PathVariable Long[] chatids) {
        return toAjax(multhelpChatService.deleteMulthelpChatByIds(chatids));
    }
}
