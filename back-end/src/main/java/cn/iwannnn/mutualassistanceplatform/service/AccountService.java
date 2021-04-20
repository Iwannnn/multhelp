package cn.iwannnn.mutualassistanceplatform.service;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.entity.Login;

@Service
public interface AccountService {

    Login getLoginInfo(String code);

    String accountLogin(String code);

    boolean checkUserProfile(String openid);

    void updateUserProfile(Account account);

    String getUserProfile(String openid);
}
