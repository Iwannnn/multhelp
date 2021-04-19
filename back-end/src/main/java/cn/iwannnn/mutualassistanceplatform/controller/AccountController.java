package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.AccountProfile;
import cn.iwannnn.mutualassistanceplatform.service.Impl.AccountServiceImpl;

@RestController
@RequestMapping("wx/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @RequestMapping("login")
    public void acocunteLogin(String code) {
        accountServiceImpl.accountLogin(code);
    }

    @RequestMapping("checkUserProfile")
    public boolean checkUserProfile(String code) {
        return accountServiceImpl.checkUserProfile(code);
    }

    @RequestMapping("updateUserProfile")
    public void updateUserProfile(@RequestBody AccountProfile accountProfile) {
        accountServiceImpl.updateUserProfile(accountProfile);
    }

    @RequestMapping("getUserProfile")
    public String getUserProfile(String code) {
        return accountServiceImpl.getUserProfile(code);
    }

}