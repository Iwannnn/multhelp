package cn.iwannnn.miniapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.miniapp.service.Impl.SessionServiceImpl;

@RestController
@RequestMapping("/wx/session")
public class SessionController {

    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @RequestMapping("checkSession_3rd")
    public boolean checkSession_3rd(String session_3rd) {
        return sessionServiceImpl.checkSession_3rd(session_3rd);
    }
}
