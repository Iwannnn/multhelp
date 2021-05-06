package cn.iwannnn.mutualassistanceplatform.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.entity.ChatAndContent;
import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.ContentMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.ChatAndContentMapper;
import cn.iwannnn.mutualassistanceplatform.mapper.MyMapper;
import cn.iwannnn.mutualassistanceplatform.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    ChatAndContentMapper ccMapper;

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
        List<Content> res = new ArrayList<Content>();
        List<ChatAndContent> ccs = ccMapper.getMessages(chatid);
        for (ChatAndContent cc : ccs) {
            res.add(contentMapper.getContent(cc.getContentid()));
        }
        return res;
    }

    @Override
    public String checkIdentity(String chatid, String session_3rd) {
        String check_openid = sessionServiceImpl.getOpenid(session_3rd);
        Chat chat = chatMapper.getChat(chatid);
        return (check_openid.equals(chat.getInitiator_openid())) ? "initiator" : "invitee";
    }

    @Override
    public List<String> getChatids(String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        System.out.println(openid);
        return chatMapper.getChats(openid);
    }

    public List<Chat> getChats(List<String> chatids) {
        List<Chat> res = new ArrayList<Chat>();
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
