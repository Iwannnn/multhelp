package com.ruoyi.miniapp.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.dto.MiniappApp;
import com.ruoyi.miniapp.mapper.MiniappLoginMapper;
import com.ruoyi.miniapp.domain.MiniappLogin;
import com.ruoyi.miniapp.service.IMiniappLoginService;

@Service
public class MiniappLoginServiceImpl implements IMiniappLoginService {

    @Autowired
    private MiniappLoginMapper loginMapper;

    public String login(String code) {
        MiniappApp app = new MiniappApp();
        MiniappLogin login = app.login(code);
        String open_id = login.getOpenid();
        String session_key = login.getSession_key();
        String session_3rd = UUID.randomUUID().toString();
        login.setSession_3rd(session_3rd);
        loginMapper.login(session_3rd, open_id, session_key);
        return session_3rd;
    }

}
