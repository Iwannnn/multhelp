package com.ruoyi.miniapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.miniapp.service.impl.MiniappSessionServiceImpl;

@RestController
@RequestMapping("/wx/session")
public class MiniappSessionController {

    @Autowired
    private MiniappSessionServiceImpl sessionServiceImpl;

    @RequestMapping("checkSession_3rd")
    public boolean checkSession_3rd(String session_3rd) {
        return sessionServiceImpl.checkSession_3rd(session_3rd);
    }
}
