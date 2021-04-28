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

    private static ContentServiceImpl contentServiceImpl;

    @Autowired
    public void setContentServiceImpl(ContentServiceImpl contentServiceImpl) {
        ContentController.contentServiceImpl = contentServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("chatid") String chatid, Session session) throws IOException {
        this.chatid = chatid;
        System.out.println("new open" + this.chatid);
    }

    @OnClose
    public void onClose() {
        System.out.println("close");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("服务器接收到的消息：" + message);
        String[] messages = message.split(" ", 2);
        System.out.println(messages[0]);
        System.out.println(messages[1]);
        System.out.println(chatid);
        Content content = contentServiceImpl.createContent(chatid, messages[0], messages[1]);
        session.getBasicRemote().sendText(objectMapper.writeValueAsString(content));
    }

}