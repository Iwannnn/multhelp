package com.ruoyi.miniapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.dto.MiniappPostMini;
import com.ruoyi.miniapp.mapper.MiniappSearchMapper;
import com.ruoyi.miniapp.service.IMiniappSearchService;

@Service
public class MiniappSearchServiceImpl implements IMiniappSearchService {
    @Autowired
    MiniappSearchMapper searchMapper;

    @Override
    public List<MiniappPostMini> search(String searchValue, int nums) {
        return searchMapper.search(searchValue, nums);
    }

}
