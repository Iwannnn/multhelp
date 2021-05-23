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

import com.ruoyi.miniapp.domain.MiniappMessage;
import com.ruoyi.miniapp.service.impl.MiniappChatServiceImpl;
import com.ruoyi.miniapp.service.impl.MiniappMessageServiceImpl;

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
    public void setCharServiceImpl(MiniappChatServiceImpl chatServiceImpl) {
        MessageWebSocket.chatServiceImpl = chatServiceImpl;
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
        connections.put(session_3rd, session);
        // webSocketSet.add(this);
        System.out.println("new message websocket " + session);
        sendData(session_3rd);
    }

    @OnClose
    public void onClose(@PathParam("session_3rd") String session_3rd) {
        System.out.println(session_3rd);
        connections.remove(session_3rd);
        // webSocketSet.remove(this);
        System.out.println("close messageWebScoket");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
    }

    public static void sendData(String session_3rd) throws IOException {
        Session session = connections.get(session_3rd);
        if (session != null)
            sendMessages(session_3rd, session);
    }

    public static List<String> getChatids(String session_3rd) {
        return chatServiceImpl.getChatids(session_3rd);
    }

    public static List<MiniappMessage> getMessages(String session_3rd, List<String> chatids) {
        List<MiniappMessage> res = new ArrayList<MiniappMessage>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(messageServiceImpl.getLastMessage(session_3rd, chatids.get(i)));
        }
        return res;
    }

    public static void sendMessages(String session_3rd, Session session) throws IOException {
        List<String> chatids = getChatids(session_3rd);
        List<MiniappMessage> messages = getMessages(session_3rd, chatids);
        ObjectMapper objectMapper = new ObjectMapper();
        session.getAsyncRemote().sendText(objectMapper.writeValueAsString(messages));
    }

}
