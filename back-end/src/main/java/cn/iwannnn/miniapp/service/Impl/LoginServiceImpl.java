package cn.iwannnn.miniapp.service.Impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.dto.App;
import cn.iwannnn.miniapp.mapper.LoginMapper;
import cn.iwannnn.miniapp.domain.Login;
import cn.iwannnn.miniapp.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public String login(String code) {
        App app = new App();
        Login login = app.login(code);
        String open_id = login.getOpenid();
        String session_key = login.getSession_key();
        String session_3rd = UUID.randomUUID().toString();
        login.setSession_3rd(session_3rd);
        loginMapper.login(session_3rd, open_id, session_key);
        return session_3rd;
    }

}
