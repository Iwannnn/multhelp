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

import com.ruoyi.miniapp.domain.MiniappMessage;
import com.ruoyi.miniapp.service.impl.MiniappChatServiceImpl;
import com.ruoyi.miniapp.service.impl.MiniappMessageServiceImpl;
import com.ruoyi.miniapp.service.impl.MiniappSessionServiceImpl;

@Slf4j
@ServerEndpoint("/wx/message/{session_3rd}")
@Component
public class MessageWebSocket {

    // private String session_3rd;

    // private Session session;

    // private static CopyOnWriteArraySet<MessageWebSocket> webSocketSet = new
    // CopyOnWriteArraySet<MessageWebSocket>();

    private static ConcurrentHashMap<String, Session> connections = new ConcurrentHashMap<>();

    private static MiniappChatServiceImpl chatServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setChatServiceImpl(MiniappChatServiceImpl chatServiceImpl) {
        MessageWebSocket.chatServiceImpl = chatServiceImpl;
    }

    private static MiniappSessionServiceImpl sessionServiceImpl;

    @Autowired
    public void setSessionServiceImpl(MiniappSessionServiceImpl sessionServiceImpl) {
        MessageWebSocket.sessionServiceImpl = sessionServiceImpl;
    }

    private static MiniappMessageServiceImpl messageServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setMessageServiceImpl(MiniappMessageServiceImpl messageServiceImpl) {
        MessageWebSocket.messageServiceImpl = messageServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("session_3rd") String session_3rd, Session session) throws IOException {
        // String session_3rd_local = session_3rd;
        // Session sessionLocal = session;
        String openid = sessionServiceImpl.getOpenid(session_3rd);

        connections.put(openid, session);
        // webSocketSet.add(this);
        log.info("open message websocket ");
        log.info("openid:" + openid);
        sendData(openid);
    }

    @OnClose
    public void onClose(@PathParam("session_3rd") String session_3rd) {
        String openid = sessionServiceImpl.getOpenid(session_3rd);
        connections.remove(openid);
        // webSocketSet.remove(this);
        log.info("close message webscoket");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
    }

    public static void sendData(String openid) throws IOException {
        Session session = connections.get(openid);
        if (session != null)
            sendMessages(openid, session);
    }

    public static List<String> getChatids(String openid) {
        System.out.println(openid);
        System.out.println(chatServiceImpl.getChatids(openid));
        return chatServiceImpl.getChatids(openid);
    }

    public static List<MiniappMessage> getMessages(String openid, List<String> chatids) {
        List<MiniappMessage> res = new ArrayList<MiniappMessage>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(messageServiceImpl.getLastMessage(openid, chatids.get(i)));
        }
        return res;
    }

    public static void sendMessages(String openid, Session session) throws IOException {
        List<String> chatids = getChatids(openid);
        List<MiniappMessage> messages = getMessages(openid, chatids);
        ObjectMapper objectMapper = new ObjectMapper();
        session.getAsyncRemote().sendText(objectMapper.writeValueAsString(messages));
    }

}
