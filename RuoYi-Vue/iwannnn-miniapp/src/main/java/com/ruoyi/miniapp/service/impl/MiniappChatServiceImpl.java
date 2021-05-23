package com.ruoyi.miniapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.mapper.MiniappChatMapper;
import com.ruoyi.miniapp.mapper.MiniappContentMapper;
import com.ruoyi.miniapp.mapper.MiniappChatAndContentMapper;
import com.ruoyi.miniapp.mapper.MiniappMyMapper;
import com.ruoyi.miniapp.domain.MiniappChat;
import com.ruoyi.miniapp.domain.MiniappChatAndContent;
import com.ruoyi.miniapp.domain.MiniappContent;
import com.ruoyi.miniapp.service.IMiniappChatService;

@Service
public class MiniappChatServiceImpl implements IMiniappChatService {

    @Autowired
    MiniappChatMapper chatMapper;

    @Autowired
    MiniappChatAndContentMapper ccMapper;

    @Autowired
    MiniappContentMapper contentMapper;

    @Autowired
    MiniappMyMapper myMapper;

    @Autowired
    MiniappSessionServiceImpl sessionServiceImpl;

    @Override
    public String createChat(String session_3rd, String postid) {
        String initiator_openid = sessionServiceImpl.getOpenid(session_3rd);
        String invitee_openid = myMapper.selectFromPost("publish_openid", postid);
        MiniappChat chat = chatMapper.checkChat(initiator_openid, invitee_openid);
        if (chat == null)
            chatMapper.createChat(initiator_openid, invitee_openid);
        MiniappChat res = chatMapper.checkChat(initiator_openid, invitee_openid);
        return res.getChatid();

    }

    @Override
    public List<MiniappContent> getPrevContents(String chatid) {
        List<MiniappContent> res = new ArrayList<MiniappContent>();
        List<MiniappChatAndContent> ccs = ccMapper.getMessages(chatid);
        for (MiniappChatAndContent cc : ccs) {
            res.add(contentMapper.getContent(cc.getContentid()));
        }
        return res;
    }

    @Override
    public String checkIdentity(String chatid, String session_3rd) {
        String check_openid = sessionServiceImpl.getOpenid(session_3rd);
        MiniappChat chat = chatMapper.getChat(chatid);
        return (check_openid.equals(chat.getInitiator_openid())) ? "initiator" : "invitee";
    }

    @Override
    public List<String> getChatids(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        System.out.println(openid);
        return chatMapper.getChats(openid);
    }

    public List<MiniappChat> getChats(List<String> chatids) {
        List<MiniappChat> res = new ArrayList<MiniappChat>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(chatMapper.getChat(chatids.get(i)));
        }
        return res;
    }

    @Override
    public void isRead(String contentid) {
        contentMapper.isRead(contentid);
    }
}
