package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;

@Service
public interface AccountService {

    boolean checkUserProfile(String openid);

    void updateUserProfile(Account account);

    Account getUserProfile(String session_3rd);

    List<Account> getOtherProfileByPostID(String session_3rd, String postid);

    List<Account> getOtherProfileByChatID(String session_3rd, String chatid);

    Account getUserProfileByOpenid(String openid);

}
