package cn.iwannnn.mutualassistanceplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.service.Impl.ChatServiceImpl;

@RestController
@RequestMapping("wx/chat")
public class ChatController {
    @Autowired
    ChatServiceImpl chatServiceImpl;

    @RequestMapping("createChat")
    public String createChat(String session_3rd, String postid) {
        return chatServiceImpl.createChat(session_3rd, postid);
    }

    @RequestMapping("getPrevContents")
    public List<Content> getPrevContents(String chatid) {
        return chatServiceImpl.getPrevContents(chatid);
    }

    @RequestMapping("checkIdentity")
    public String checkIdentity(String chatid, String session_3rd) {
        return chatServiceImpl.checkIdentity(chatid, session_3rd);
    }

    @RequestMapping("isRead")
    public void isRead(String contentid) {
        chatServiceImpl.isRead(contentid);
    }
}
