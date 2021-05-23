package com.ruoyi.miniapp.service;

import java.util.List;

import com.ruoyi.miniapp.dto.MiniappPostMini;

public interface IMiniappSearchService {
    List<MiniappPostMini> search(String searchValue, int nums);
}
