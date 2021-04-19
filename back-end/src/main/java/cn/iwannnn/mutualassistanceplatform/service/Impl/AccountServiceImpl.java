package cn.iwannnn.mutualassistanceplatform.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.AccountProfile;
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
    public void accountLogin(String code) {
        Login login = getLoginInfo(code);
        String openid = login.getOpenid();
        String session_key = login.getSession_key();
        accountMapper.login(openid);
        accountMapper.updateProfile("session_key", session_key, openid);
    }

    @Override
    public boolean checkUserProfile(String code) {
        Login login = getLoginInfo(code);
        String openid = login.getOpenid();
        String session_key = login.getSession_key();
        accountMapper.updateProfile("session_key", session_key, openid);
        AccountProfile accountProfile = accountMapper.selectProfile(openid);
        return !(accountProfile.getNickName() == null);
    }

    @Override
    public void updateUserProfile(AccountProfile accountProfile) {
        System.out.println(accountProfile.toString());
        Login login = getLoginInfo(accountProfile.getCode());
        String openid = login.getOpenid();
        String session_key = login.getSession_key();
        accountMapper.updateProfile("session_key", session_key, openid);
        accountMapper.updateProfile("nickname", accountProfile.getNickName(), openid);
        accountMapper.updateProfile("avatarurl", accountProfile.getAvatarUrl(), openid);
        accountMapper.updateProfile("gender", accountProfile.getGender(), openid);
        accountMapper.updateProfile("language", accountProfile.getLanguage(), openid);
        accountMapper.updateProfile("city", accountProfile.getCity(), openid);
        accountMapper.updateProfile("province", accountProfile.getProvince(), openid);
        accountMapper.updateProfile("country", accountProfile.getCountry(), openid);
    }

    @Override
    public String getUserProfile(String code) {
        Login login = getLoginInfo(code);
        String openid = login.getOpenid();
        String session_key = login.getSession_key();
        accountMapper.updateProfile("session_key", session_key, openid);
        AccountProfile accountProfile = accountMapper.selectProfile(openid);
        ObjectMapper mapper = new ObjectMapper();
        String res = "";
        try {
            res = mapper.writeValueAsString(accountProfile);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
