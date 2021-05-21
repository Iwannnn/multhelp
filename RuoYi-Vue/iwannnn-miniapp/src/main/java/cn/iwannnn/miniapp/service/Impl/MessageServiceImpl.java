package cn.iwannnn.miniapp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.pojo.Account;
import cn.iwannnn.miniapp.pojo.Message;
import cn.iwannnn.miniapp.mapper.ChatAndContentMapper;
import cn.iwannnn.miniapp.mapper.ChatMapper;
import cn.iwannnn.miniapp.mapper.ContentMapper;
import cn.iwannnn.miniapp.mapper.MessageMapper;
import cn.iwannnn.miniapp.pojo.Chat;
import cn.iwannnn.miniapp.pojo.ChatAndContent;
import cn.iwannnn.miniapp.pojo.Content;
import cn.iwannnn.miniapp.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    ChatAndContentMapper ccMapper;

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    SessionServiceImpl sessionServiceImpl;

    @Autowired
    AccountServiceImpl accountServiceImpl;

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
    public Message getLastMessage(String session_3rd, String chatid) {
        Message message = new Message();
        ChatAndContent cc = ccMapper.getLast(chatid);
        Chat chat = chatMapper.getChat(chatid);
        String myOpenid = sessionServiceImpl.getOpenid(session_3rd);
        String otherOpenid = (myOpenid.equals(chat.getInitiator_openid())) ? chat.getInitiator_openid()
                : chat.getInvitee_openid();
        Account otherAccount = accountServiceImpl.getUserProfileByOpenid(otherOpenid);
        Content lastContent = contentMapper.getContent(cc.getContentid());
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
