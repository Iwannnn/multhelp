package cn.iwannnn.mutualassistanceplatform.service;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.AccountProfile;
import cn.iwannnn.mutualassistanceplatform.entity.Login;

@Service
public interface AccountService {

    Login getLoginInfo(String code);

    void accountLogin(String code);

    boolean checkUserProfile(String code);

    void updateUserProfile(AccountProfile accountProfile);

    String getUserProfile(String code);
}
