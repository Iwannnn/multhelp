package cn.iwannnn.mutualassistanceplatform.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.ContentMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MessageMapper;
import cn.iwannnn.mutualassistanceplatform.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    ChatMapper chatMapper;

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

        messageMapper.insertMessage(chatid, contentid);// 绑定
        return contentBack;
    }

}
