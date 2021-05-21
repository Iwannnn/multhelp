package com.ruoyi.multhelp.service;

import org.springframework.stereotype.Service;

import com.ruoyi.multhelp.domain.MiniappContent;

@Service
public interface IMiniappContentService {

    MiniappContent createContent(String chatid, String session_3rd, String content);

}
