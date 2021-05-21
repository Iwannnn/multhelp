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
import com.ruoyi.multhelp.domain.MulthelpAccount;
import com.ruoyi.multhelp.service.IMulthelpAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户账号Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/account")
public class MulthelpAccountController extends BaseController {
    @Autowired
    private IMulthelpAccountService multhelpAccountService;

    /**
     * 查询用户账号列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpAccount multhelpAccount) {
        startPage();
        List<MulthelpAccount> list = multhelpAccountService.selectMulthelpAccountList(multhelpAccount);
        return getDataTable(list);
    }

    /**
     * 导出用户账号列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:export')")
    @Log(title = "用户账号", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpAccount multhelpAccount) {
        List<MulthelpAccount> list = multhelpAccountService.selectMulthelpAccountList(multhelpAccount);
        ExcelUtil<MulthelpAccount> util = new ExcelUtil<MulthelpAccount>(MulthelpAccount.class);
        return util.exportExcel(list, "用户账号数据");
    }

    /**
     * 获取用户账号详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:query')")
    @GetMapping(value = "/{openid}")
    public AjaxResult getInfo(@PathVariable("openid") String openid) {
        return AjaxResult.success(multhelpAccountService.selectMulthelpAccountById(openid));
    }

    /**
     * 新增用户账号
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:add')")
    @Log(title = "用户账号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpAccount multhelpAccount) {
        return toAjax(multhelpAccountService.insertMulthelpAccount(multhelpAccount));
    }

    /**
     * 修改用户账号
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:edit')")
    @Log(title = "用户账号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpAccount multhelpAccount) {
        return toAjax(multhelpAccountService.updateMulthelpAccount(multhelpAccount));
    }

    /**
     * 删除用户账号
     */
    @PreAuthorize("@ss.hasPermi('multhelp:account:remove')")
    @Log(title = "用户账号", businessType = BusinessType.DELETE)
    @DeleteMapping("/{openids}")
    public AjaxResult remove(@PathVariable String[] openids) {
        return toAjax(multhelpAccountService.deleteMulthelpAccountByIds(openids));
    }
}
