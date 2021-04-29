package cn.iwannnn.mutualassistanceplatform.controller;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.service.Impl.ContentServiceImpl;

@RestController
@ServerEndpoint("/wx/chat/{chatid}")
public class ContentController {

    private String chatid;

    private static ContentServiceImpl contentServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setContentServiceImpl(ContentServiceImpl contentServiceImpl) {
        ContentController.contentServiceImpl = contentServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("chatid") String chatid, Session session) throws IOException {
        this.chatid = chatid;// 获取chatid经行绑定
        System.out.println("new open" + this.chatid);
    }

    @OnClose
    public void onClose() {
        System.out.println("close");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] messages = message.split(" ", 2);
        String session_3rd = messages[0];
        String content = messages[1];
        Content contentBack = contentServiceImpl.createContent(chatid, session_3rd, content);
        session.getBasicRemote().sendText(objectMapper.writeValueAsString(contentBack));
    }

}