package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.service.Impl.AccountServiceImpl;

@RestController
@RequestMapping("wx/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @RequestMapping("login")
    public String acocunteLogin(String code) {
        return accountServiceImpl.accountLogin(code);
    }

    @RequestMapping("checkUserProfile")
    public boolean checkUserProfile(String openid) {
        return accountServiceImpl.checkUserProfile(openid);
    }

    @RequestMapping("updateUserProfile")
    public void updateUserProfile(@RequestBody Account account) {
        accountServiceImpl.updateUserProfile(account);
    }

    @RequestMapping("getUserProfile")
    public String getUserProfile(String openid) {
        return accountServiceImpl.getUserProfile(openid);
    }

}