package cn.iwannnn.mutualassistanceplatform.service;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;

@Service
public interface AccountService {

    boolean checkUserProfile(String openid);

    void updateUserProfile(Account account);

    String getUserProfile(String openid);
}
