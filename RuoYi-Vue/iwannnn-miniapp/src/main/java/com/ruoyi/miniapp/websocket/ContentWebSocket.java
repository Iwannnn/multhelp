package com.ruoyi.miniapp.websocket;

import java.io.IOException;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruoyi.miniapp.domain.MiniappContent;
import com.ruoyi.miniapp.service.impl.MiniappContentServiceImpl;

@ServerEndpoint("/wx/chat/{chatid}")
@Component
public class ContentWebSocket {

    private String chatid;

    private Session session;

    private static MiniappContentServiceImpl contentServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setContentServiceImpl(MiniappContentServiceImpl contentServiceImpl) {
        ContentWebSocket.contentServiceImpl = contentServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("chatid") String chatid, Session session) throws IOException {
        this.chatid = chatid;// 获取chatid经行绑定
        this.session = session;
        System.out.println("new open" + this.chatid);
    }

    @OnClose
    public void onClose() {
        System.out.println("close contentWebSocket");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        String[] messages = message.split(" ", 2);
        String session_3rd = messages[0];
        String content = messages[1];
        List<String> openids = contentServiceImpl.getOpenids(chatid);
        MiniappContent contentBack = contentServiceImpl.createContent(chatid, session_3rd, content);
        sendMessage(contentBack);
        MessageWebSocket.sendData(openids.get(0));
        MessageWebSocket.sendData(openids.get(1));

    }

    public void sendMessage(MiniappContent content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.session.getAsyncRemote().sendText(objectMapper.writeValueAsString(content));
    }

}