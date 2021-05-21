package com.ruoyi.multhelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.multhelp.dto.MiniappPostMini;
import com.ruoyi.multhelp.service.impl.MiniappSearchServiceImpl;

@RestController
@RequestMapping("/wx")
public class MiniappSearchController {

    @Autowired
    MiniappSearchServiceImpl searchServiceImpl;

    @RequestMapping("search")
    public List<MiniappPostMini> search(String searchValue, int nums) {
        return searchServiceImpl.search(searchValue, nums);
    }
}
