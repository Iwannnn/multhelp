package cn.iwannnn.mutualassistanceplatform.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.entity.App;
import cn.iwannnn.mutualassistanceplatform.entity.Login;
import cn.iwannnn.mutualassistanceplatform.mapper.AccountMapper;
import cn.iwannnn.mutualassistanceplatform.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Login getLoginInfo(String code) {
        App app = new App();
        Login login = app.login(code);
        return login;
    }

    @Override
    public String accountLogin(String code) {
        Login login = getLoginInfo(code);
        String openid = login.getOpenid();
        String session_key = login.getSession_key();
        accountMapper.login(openid);
        accountMapper.updateProfile("session_key", session_key, openid);
        return openid;
    }

    @Override
    public boolean checkUserProfile(String openid) {
        Account account = accountMapper.selectProfile(openid);
        return !(account.getNickName() == null);
    }

    @Override
    public void updateUserProfile(Account account) {
        accountMapper.updateProfile("nickname", account.getNickName(), account.getOpenid());
        accountMapper.updateProfile("avatarurl", account.getAvatarUrl(), account.getOpenid());
        accountMapper.updateProfile("gender", account.getGender(), account.getOpenid());
        accountMapper.updateProfile("language", account.getLanguage(), account.getOpenid());
        accountMapper.updateProfile("city", account.getCity(), account.getOpenid());
        accountMapper.updateProfile("province", account.getProvince(), account.getOpenid());
        accountMapper.updateProfile("country", account.getCountry(), account.getOpenid());
    }

    @Override
    public String getUserProfile(String openid) {
        Account account = accountMapper.selectProfile(openid);
        ObjectMapper mapper = new ObjectMapper();
        String res = "";
        try {
            res = mapper.writeValueAsString(account);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
