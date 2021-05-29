package com.ruoyi.miniapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.ruoyi.miniapp.domain.MiniappAccount;
import com.ruoyi.miniapp.domain.MiniappMessage;
import com.ruoyi.miniapp.mapper.MiniappChatAndContentMapper;
import com.ruoyi.miniapp.mapper.MiniappChatMapper;
import com.ruoyi.miniapp.mapper.MiniappContentMapper;
import com.ruoyi.miniapp.domain.MiniappChat;
import com.ruoyi.miniapp.domain.MiniappChatAndContent;
import com.ruoyi.miniapp.domain.MiniappContent;
import com.ruoyi.miniapp.service.IMiniappMessageService;

@Slf4j
@Service
public class MiniappMessageServiceImpl implements IMiniappMessageService {

    @Autowired
    MiniappChatAndContentMapper ccMapper;

    @Autowired
    MiniappChatMapper chatMapper;

    @Autowired
    MiniappContentMapper contentMapper;

    @Autowired
    MiniappSessionServiceImpl sessionServiceImpl;

    @Autowired
    MiniappAccountServiceImpl accountServiceImpl;

    // @Override
    // public void updata(String chatid, String last_contentid) {
    // String checkChatid = messageMapper.checkChatid(chatid);
    // if (checkChatid.equals(chatid)) {
    // messageMapper.updataMessage(chatid, last_contentid);
    // } else {
    // messageMapper.createMessage(chatid, last_contentid);
    // }
    // }

    @Override
    public MiniappMessage getLastMessage(String openid, String chatid) {
        MiniappMessage message = new MiniappMessage();
        MiniappChatAndContent cc = ccMapper.getLast(chatid);
        MiniappChat chat = chatMapper.getChat(chatid);
        String initiatoeOpenid = chat.getInitiator_openid();
        String inviteeOpenid = chat.getInvitee_openid();
        String myOpenid = openid;
        String otherOpenid;
        if (myOpenid.equals(initiatoeOpenid))
            otherOpenid = inviteeOpenid;
        else
            otherOpenid = initiatoeOpenid;
        log.info("initiator:  " + initiatoeOpenid);
        log.info("invitee:  " + inviteeOpenid);
        log.info("myOpenid:  " + myOpenid);
        log.info("otherOpenid:  " + otherOpenid);
        MiniappAccount otherAccount = accountServiceImpl.getUserProfileByOpenid(otherOpenid);
        MiniappContent lastContent = contentMapper.getContent(cc.getContentid());
        message.setChatid(chatid);
        message.setLastContent(cc.getContentid());
        message.setMyOpenid(myOpenid);
        message.setOtherOpenid(otherOpenid);
        message.setNickName(otherAccount.getNickName());
        message.setAvatarUrl(otherAccount.getAvatarUrl());
        message.setGender(otherAccount.getGender());
        message.setLastContent(lastContent.getContent());
        message.setLastContentTime(lastContent.getCreate_time());
        if (myOpenid.equals(otherOpenid))
            message.setUnread("0");
        else
            message.setUnread(contentMapper.countUnread(myOpenid, otherOpenid));
        return message;
    }
}
