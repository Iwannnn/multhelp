package com.ruoyi.miniapp.service;

import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.domain.MiniappContent;

@Service
public interface IMiniappContentService {

    MiniappContent createContent(String chatid, String session_3rd, String content);

}
