package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.service.Impl.AccountServiceImpl;
import cn.iwannnn.mutualassistanceplatform.service.Impl.LoginServiceImpl;

@RestController
@RequestMapping("wx/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @RequestMapping("login")
    public String acocunteLogin(String code) {
        return loginServiceImpl.login(code);
    }

    @RequestMapping("checkUserProfile")
    public boolean checkUserProfile(String session_3rd) {
        return accountServiceImpl.checkUserProfile(session_3rd);
    }

    @RequestMapping("updateUserProfile")
    public void updateUserProfile(@RequestBody Account account) {
        accountServiceImpl.updateUserProfile(account);
    }

    @RequestMapping("getUserProfile")
    public String getUserProfile(String session_3rd) {
        return accountServiceImpl.getUserProfile(session_3rd);
    }

}