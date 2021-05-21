package com.ruoyi.multhelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.multhelp.domain.MiniappAccount;
import com.ruoyi.multhelp.service.impl.MiniappAccountServiceImpl;
import com.ruoyi.multhelp.service.impl.MiniappLoginServiceImpl;

@RestController
@RequestMapping("/wx/account")
public class MiniappAccountController {

    @Autowired
    private MiniappAccountServiceImpl accountServiceImpl;

    @Autowired
    private MiniappLoginServiceImpl loginServiceImpl;

    @RequestMapping("login")
    public String acocunteLogin(String code) {
        return loginServiceImpl.login(code);
    }

    @RequestMapping("checkUserProfile")
    public boolean checkUserProfile(String session_3rd) {
        return accountServiceImpl.checkUserProfile(session_3rd);
    }

    @RequestMapping("updateUserProfile")
    public void updateUserProfile(@RequestBody MiniappAccount account) {
        accountServiceImpl.updateUserProfile(account);
    }

    @RequestMapping("getUserProfile")
    public MiniappAccount getUserProfile(String session_3rd) {
        return accountServiceImpl.getUserProfile(session_3rd);
    }

    @RequestMapping("getOtherProfileByPostID")
    public List<MiniappAccount> getOtherProfileByPostID(String session_3rd, String postid) {
        return accountServiceImpl.getOtherProfileByPostID(session_3rd, postid);
    }

    @RequestMapping("getOtherProfileByChatID")
    public List<MiniappAccount> getOtherProfileByChatID(String session_3rd, String chatid) {
        return accountServiceImpl.getOtherProfileByChatID(session_3rd, chatid);
    }

}