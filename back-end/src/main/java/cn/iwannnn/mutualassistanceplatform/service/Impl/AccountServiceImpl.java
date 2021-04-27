package cn.iwannnn.mutualassistanceplatform.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.mapper.AccountMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MyMapper;
import cn.iwannnn.mutualassistanceplatform.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @Override
    public boolean checkUserProfile(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        accountMapper.insertOpenid(openid);
        Account account = accountMapper.selectProfile(openid);
        return !(account.getNickName().equals(""));
    }

    @Override
    public void updateUserProfile(Account account) {
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
    public Account getUserProfile(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        return accountMapper.selectProfile(openid);
    }

    @Override
    public List<Account> getOtherProfileByPostID(String session_3rd, String postid) {
        List<Account> res = new ArrayList<>();
        String publish_openid = myMapper.selectFromPost("publish_openid", postid);
        res.add(getUserProfile(session_3rd));
        res.add(getUserProfileByOpenid(publish_openid));
        return res;

    }

    @Override
    public List<Account> getOtherProfileByChatID(String session_3rd, String chatid) {
        List<Account> res = new ArrayList<>();
        Account myAccount = getUserProfile(session_3rd);
        Chat chat = chatMapper.getChat(chatid);
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
    public Account getUserProfileByOpenid(String openid) {
        return accountMapper.selectProfile(openid);
    }
}
