package cn.iwannnn.miniapp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.mapper.ChatMapper;
import cn.iwannnn.miniapp.mapper.ContentMapper;
import cn.iwannnn.miniapp.mapper.MessageMapper;
import cn.iwannnn.miniapp.domain.Chat;
import cn.iwannnn.miniapp.domain.Content;
import cn.iwannnn.miniapp.mapper.ChatAndContentMapper;
import cn.iwannnn.miniapp.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    ChatAndContentMapper ccMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    SessionServiceImpl sessionServiceImpl;

    @Override
    public Content createContent(String chatid, String session_3rd, String content) {
        Chat chat = chatMapper.getChat(chatid);
        String initiator_openid = chatMapper.selectFromChat("initiator_openid", chatid);
        String send_openid = sessionServiceImpl.getOpenid(session_3rd);// 获取send_openid
        String receive_openid = (chat.getInitiator_openid().equals(send_openid)) ? chat.getInvitee_openid()// 获取receive_openid
                : chat.getInitiator_openid();
        String sender = (initiator_openid.equals(send_openid)) ? "initiator" : "invitee";
        contentMapper.insertContent(send_openid, receive_openid, sender, content);// 加入数据库
        String contentid = contentMapper.getContentid();// 获取contentid
        Content contentBack = contentMapper.getContent(contentid);
        ccMapper.insertMessage(chatid, contentid);// 绑定
        // messageMapper.updataMessage(chatid, contentid);// 更新最新contentid
        return contentBack;
    }

}
