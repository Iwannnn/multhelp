package com.ruoyi.miniapp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.mapper.MiniappSessionMapper;
import com.ruoyi.miniapp.service.IMiniappSessionService;

@Service
public class MiniappSessionServiceImpl implements IMiniappSessionService {

    @Autowired
    MiniappSessionMapper sessionUtilsMapper;

    public String getOpenid(String session_3rd) {
        return sessionUtilsMapper.select("openid", session_3rd);
    }

    public boolean checkSession_3rd(String session_3rd) {
        String createTime = sessionUtilsMapper.select("create_time", session_3rd);
        Date date = new Date();
        long createUnixTimeStamp = sessionUtilsMapper.selectTime(createTime);
        long nowUnixTimeStamp = date.getTime() / 1000;
        return (nowUnixTimeStamp - createUnixTimeStamp <= 6000);
    }
}
