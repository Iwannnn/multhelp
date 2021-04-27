package cn.iwannnn.mutualassistanceplatform.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MyMapper;
import cn.iwannnn.mutualassistanceplatform.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    MyMapper myMapper;

    @Autowired
    SessionServiceImpl sessionServiceImpl;

    @Override
    public void createChat(String session_3rd, String postid) {
        String initiator_openid = sessionServiceImpl.getOpenid(session_3rd);
        String invitee_openid = myMapper.selectFromPost("publish_openid", postid);
        Chat chat = chatMapper.checkChat(initiator_openid, invitee_openid);
        if (chat == null)
            chatMapper.createChat(initiator_openid, invitee_openid);
    }
}
