package com.ruoyi.miniapp.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.ruoyi.miniapp.domain.MiniappContent;
import com.ruoyi.miniapp.service.impl.MiniappContentServiceImpl;

@Slf4j
@ServerEndpoint("/wx/chat/{chatid}")
@Component
public class ContentWebSocket {

    private String chatid;

    private Session session;

    private static MiniappContentServiceImpl contentServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    private static ConcurrentHashMap<String, List<Session>> connections = new ConcurrentHashMap<>();

    @Autowired
    public void setContentServiceImpl(MiniappContentServiceImpl contentServiceImpl) {
        ContentWebSocket.contentServiceImpl = contentServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("chatid") String chatid, Session session) throws IOException {
        this.chatid = chatid;// 获取chatid经行绑定
        this.session = session;
        List<Session> sessions = connections.get(chatid);
        if (sessions == null)
            sessions = new ArrayList<Session>();
        sessions.add(session);
        connections.put(chatid, sessions);
        log.info("chat websocket : " + chatid + " sessions: " + session.toString());
    }

    @OnClose
    public void onClose() {
        List<Session> sessions = connections.get(chatid);
        for (int i = 0; i < sessions.size(); ++i) {
            if (sessions.get(i) == session)
                sessions.remove(i);
        }
        connections.remove(chatid);
        if (sessions != null)
            connections.put(chatid, sessions);
        log.info("close contentWebSocket" + connections.get(chatid));
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
        List<Session> sessions = connections.get(chatid);
        for (int i = 0; i < sessions.size(); ++i) {
            log.info("send content to " + sessions.get(i));
            sessions.get(i).getAsyncRemote().sendText(objectMapper.writeValueAsString(content));
        }
    }

}