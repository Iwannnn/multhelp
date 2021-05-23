package com.ruoyi.miniapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.miniapp.mapper.MiniappChatMapper;
import com.ruoyi.miniapp.mapper.MiniappContentMapper;
import com.ruoyi.miniapp.domain.MiniappChat;
import com.ruoyi.miniapp.domain.MiniappContent;
import com.ruoyi.miniapp.mapper.MiniappChatAndContentMapper;
import com.ruoyi.miniapp.service.IMiniappContentService;

@Service
public class MiniappContentServiceImpl implements IMiniappContentService {

    @Autowired
    MiniappContentMapper contentMapper;

    @Autowired
    MiniappChatMapper chatMapper;

    @Autowired
    MiniappChatAndContentMapper ccMapper;

    @Autowired
    MiniappSessionServiceImpl sessionServiceImpl;

    @Override
    public MiniappContent createContent(String chatid, String session_3rd, String content) {
        MiniappChat chat = chatMapper.getChat(chatid);
        String initiator_openid = chatMapper.selectFromChat("initiator_openid", chatid);
        String send_openid = sessionServiceImpl.getOpenid(session_3rd);// 获取send_openid
        String receive_openid = (chat.getInitiator_openid().equals(send_openid)) ? chat.getInvitee_openid()// 获取receive_openid
                : chat.getInitiator_openid();
        String sender = (initiator_openid.equals(send_openid)) ? "initiator" : "invitee";
        contentMapper.insertContent(send_openid, receive_openid, sender, content);// 加入数据库
        String contentid = contentMapper.getContentid();// 获取contentid
        MiniappContent contentBack = contentMapper.getContent(contentid);
        ccMapper.insertMessage(chatid, contentid);// 绑定
        // messageMapper.updataMessage(chatid, contentid);// 更新最新contentid
        return contentBack;
    }

}
