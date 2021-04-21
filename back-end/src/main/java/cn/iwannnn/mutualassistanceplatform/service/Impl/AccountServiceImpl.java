package cn.iwannnn.mutualassistanceplatform.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.mapper.AccountMapper;
import cn.iwannnn.mutualassistanceplatform.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private SessionServiceImpl sessionUtils;

    @Override
    public boolean checkUserProfile(String session_3rd) {
        String openid = sessionUtils.getOpenid(session_3rd);
        accountMapper.insertOpenid(openid);
        Account account = accountMapper.selectProfile(openid);
        return !(account.getNickName().equals(""));
    }

    @Override
    public void updateUserProfile(Account account) {
        String openid = sessionUtils.getOpenid(account.getSession_3rd());
        accountMapper.updateProfile("nickname", account.getNickName(), openid);
        accountMapper.updateProfile("avatarurl", account.getAvatarUrl(), openid);
        accountMapper.updateProfile("gender", account.getGender(), openid);
        accountMapper.updateProfile("language", account.getLanguage(), openid);
        accountMapper.updateProfile("city", account.getCity(), openid);
        accountMapper.updateProfile("province", account.getProvince(), openid);
        accountMapper.updateProfile("country", account.getCountry(), openid);
    }

    @Override
    public String getUserProfile(String session_3rd) {
        String openid = sessionUtils.getOpenid(session_3rd);
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
