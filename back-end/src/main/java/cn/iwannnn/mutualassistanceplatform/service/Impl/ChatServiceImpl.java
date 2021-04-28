package cn.iwannnn.mutualassistanceplatform.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.entity.Message;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.ContentMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MessageMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MyMapper;
import cn.iwannnn.mutualassistanceplatform.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    MyMapper myMapper;

    @Autowired
    SessionServiceImpl sessionServiceImpl;

    @Override
    public String createChat(String session_3rd, String postid) {
        String initiator_openid = sessionServiceImpl.getOpenid(session_3rd);
        String invitee_openid = myMapper.selectFromPost("publish_openid", postid);
        Chat chat = chatMapper.checkChat(initiator_openid, invitee_openid);
        if (chat == null)
            chatMapper.createChat(initiator_openid, invitee_openid);
        Chat res = chatMapper.checkChat(initiator_openid, invitee_openid);
        return res.getChatid();

    }

    @Override
    public List<Content> getPrevContents(String chatid) {
        System.out.println(chatid);
        List<Content> res = new ArrayList<Content>();
        List<Message> messages = messageMapper.getMessages(chatid);
        System.out.println(messages.toString());
        for (Message message : messages) {
            res.add(contentMapper.getContent(message.getContentid()));
        }
        return res;
    }
}
