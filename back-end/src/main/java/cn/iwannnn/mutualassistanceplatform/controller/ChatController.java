package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.service.Impl.ChatServiceImpl;

@RestController
@RequestMapping("wx/chat")
public class ChatController {
    @Autowired
    ChatServiceImpl chatServiceImpl;

    @RequestMapping("createChat")
    public void createChat(String session_3rd, String postid) {
        chatServiceImpl.createChat(session_3rd, postid);
    }
}
