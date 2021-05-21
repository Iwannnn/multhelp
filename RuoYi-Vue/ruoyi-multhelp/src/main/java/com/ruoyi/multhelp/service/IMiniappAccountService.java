package com.ruoyi.multhelp.service;

import java.util.List;

import com.ruoyi.multhelp.domain.MiniappAccount;

public interface IMiniappAccountService {

    boolean checkUserProfile(String openid);

    void updateUserProfile(MiniappAccount account);

    MiniappAccount getUserProfile(String session_3rd);

    List<MiniappAccount> getOtherProfileByPostID(String session_3rd, String postid);

    List<MiniappAccount> getOtherProfileByChatID(String session_3rd, String chatid);

    MiniappAccount getUserProfileByOpenid(String openid);

}
