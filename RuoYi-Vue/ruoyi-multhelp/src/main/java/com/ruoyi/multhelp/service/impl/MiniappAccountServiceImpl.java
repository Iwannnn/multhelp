package com.ruoyi.multhelp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.multhelp.domain.MiniappAccount;
import com.ruoyi.multhelp.mapper.MiniappAccountMapper;
import com.ruoyi.multhelp.mapper.MiniappChatMapper;
import com.ruoyi.multhelp.mapper.MiniappMyMapper;
import com.ruoyi.multhelp.domain.MiniappChat;
import com.ruoyi.multhelp.service.IMiniappAccountService;

@Service
public class MiniappAccountServiceImpl implements IMiniappAccountService {

    @Autowired
    private MiniappAccountMapper accountMapper;

    @Autowired
    private MiniappMyMapper myMapper;

    @Autowired
    private MiniappChatMapper chatMapper;

    @Autowired
    private MiniappSessionServiceImpl sessionServiceImpl;

    @Override
    public boolean checkUserProfile(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        accountMapper.insertOpenid(openid);
        MiniappAccount account = accountMapper.selectProfile(openid);
        return !(account.getNickName().equals(""));
    }

    @Override
    public void updateUserProfile(MiniappAccount account) {
        String openid = sessionServiceImpl.getOpenid(account.getSession_3rd());
        accountMapper.updateProfile("nickname", account.getNickName(), openid);
        accountMapper.updateProfile("avatarurl", account.getAvatarUrl(), openid);
        accountMapper.updateProfile("gender", account.getGender(), openid);
        accountMapper.updateProfile("language", account.getLanguage(), openid);
        accountMapper.updateProfile("city", account.getCity(), openid);
        accountMapper.updateProfile("province", account.getProvince(), openid);
        accountMapper.updateProfile("country", account.getCountry(), openid);
    }

    @Override
    public MiniappAccount getUserProfile(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        return accountMapper.selectProfile(openid);
    }

    @Override
    public List<MiniappAccount> getOtherProfileByPostID(String session_3rd, String postid) {
        List<MiniappAccount> res = new ArrayList<>();
        String publish_openid = myMapper.selectFromPost("publish_openid", postid);
        res.add(getUserProfile(session_3rd));
        res.add(getUserProfileByOpenid(publish_openid));
        return res;

    }

    @Override
    public List<MiniappAccount> getOtherProfileByChatID(String session_3rd, String chatid) {
        List<MiniappAccount> res = new ArrayList<>();
        MiniappAccount myAccount = getUserProfile(session_3rd);
        MiniappChat chat = chatMapper.getChat(chatid);
        String my_openid = myAccount.getOpenid(), initiator_openid = chat.getInitiator_openid(),
                invitee_openid = chat.getInvitee_openid();
        res.add(myAccount);
        if (my_openid.equals(initiator_openid))
            res.add(getUserProfileByOpenid(initiator_openid));
        else
            res.add(getUserProfileByOpenid(invitee_openid));
        return res;
    }

    @Override
    public MiniappAccount getUserProfileByOpenid(String openid) {
        return accountMapper.selectProfile(openid);
    }
}
