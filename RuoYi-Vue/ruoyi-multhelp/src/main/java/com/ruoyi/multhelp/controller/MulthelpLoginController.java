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
import com.ruoyi.multhelp.domain.MulthelpLogin;
import com.ruoyi.multhelp.service.IMulthelpLoginService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 登陆验证Controller
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
@RestController
@RequestMapping("/multhelp/login")
public class MulthelpLoginController extends BaseController
{
    @Autowired
    private IMulthelpLoginService multhelpLoginService;

    /**
     * 查询登陆验证列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:list')")
    @GetMapping("/list")
    public TableDataInfo list(MulthelpLogin multhelpLogin)
    {
        startPage();
        List<MulthelpLogin> list = multhelpLoginService.selectMulthelpLoginList(multhelpLogin);
        return getDataTable(list);
    }

    /**
     * 导出登陆验证列表
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:export')")
    @Log(title = "登陆验证", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MulthelpLogin multhelpLogin)
    {
        List<MulthelpLogin> list = multhelpLoginService.selectMulthelpLoginList(multhelpLogin);
        ExcelUtil<MulthelpLogin> util = new ExcelUtil<MulthelpLogin>(MulthelpLogin.class);
        return util.exportExcel(list, "登陆验证数据");
    }

    /**
     * 获取登陆验证详细信息
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:query')")
    @GetMapping(value = "/{session3rd}")
    public AjaxResult getInfo(@PathVariable("session3rd") String session3rd)
    {
        return AjaxResult.success(multhelpLoginService.selectMulthelpLoginById(session3rd));
    }

    /**
     * 新增登陆验证
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:add')")
    @Log(title = "登陆验证", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MulthelpLogin multhelpLogin)
    {
        return toAjax(multhelpLoginService.insertMulthelpLogin(multhelpLogin));
    }

    /**
     * 修改登陆验证
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:edit')")
    @Log(title = "登陆验证", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MulthelpLogin multhelpLogin)
    {
        return toAjax(multhelpLoginService.updateMulthelpLogin(multhelpLogin));
    }

    /**
     * 删除登陆验证
     */
    @PreAuthorize("@ss.hasPermi('multhelp:login:remove')")
    @Log(title = "登陆验证", businessType = BusinessType.DELETE)
	@DeleteMapping("/{session3rds}")
    public AjaxResult remove(@PathVariable String[] session3rds)
    {
        return toAjax(multhelpLoginService.deleteMulthelpLoginByIds(session3rds));
    }
}
