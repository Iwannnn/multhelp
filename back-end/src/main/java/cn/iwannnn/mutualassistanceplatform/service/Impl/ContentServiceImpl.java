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
        String send_openid = sessionServiceImpl.getOpenid(session_3rd);// 获取send_openid
        System.out.println(send_openid);
        Chat chat = chatMapper.getChat(chatid);
        String receive_openid = (chat.getInitiator_openid().equals(send_openid)) ? chat.getInvitee_openid()// 获取receive_openid
                : chat.getInitiator_openid();
        System.out.println(receive_openid);
        contentMapper.insertContent(send_openid, receive_openid, content);// 加入数据库
        String contentid = contentMapper.getContentid();// 获取contentid
        Content contentObj = contentMapper.getContent(contentid);
        System.out.println(contentObj.toString());
        messageMapper.insertMessage(chatid, contentid);// 绑定
        return contentObj;
    }

}
