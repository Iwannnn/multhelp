package cn.iwannnn.miniapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.miniapp.pojo.Account;
import cn.iwannnn.miniapp.service.Impl.AccountServiceImpl;
import cn.iwannnn.miniapp.service.Impl.LoginServiceImpl;

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
    public Account getUserProfile(String session_3rd) {
        return accountServiceImpl.getUserProfile(session_3rd);
    }

    @RequestMapping("getOtherProfileByPostID")
    public List<Account> getOtherProfileByPostID(String session_3rd, String postid) {
        return accountServiceImpl.getOtherProfileByPostID(session_3rd, postid);
    }

    @RequestMapping("getOtherProfileByChatID")
    public List<Account> getOtherProfileByChatID(String session_3rd, String chatid) {
        return accountServiceImpl.getOtherProfileByChatID(session_3rd, chatid);
    }

}