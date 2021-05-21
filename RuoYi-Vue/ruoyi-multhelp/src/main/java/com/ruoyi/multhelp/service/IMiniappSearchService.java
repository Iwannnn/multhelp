package com.ruoyi.multhelp.service;

import java.util.List;

import com.ruoyi.multhelp.dto.MiniappPostMini;

public interface IMiniappSearchService {
    List<MiniappPostMini> search(String searchValue, int nums);
}
