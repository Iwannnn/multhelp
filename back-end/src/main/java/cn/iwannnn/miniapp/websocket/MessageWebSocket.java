package cn.iwannnn.miniapp.websocket;

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

import cn.iwannnn.miniapp.domain.Message;
import cn.iwannnn.miniapp.service.Impl.ChatServiceImpl;
import cn.iwannnn.miniapp.service.Impl.MessageServiceImpl;

@ServerEndpoint("/wx/message/{session_3rd}")
@Component
public class MessageWebSocket {

    // private String session_3rd;

    // private Session session;

    // private static CopyOnWriteArraySet<MessageWebSocket> webSocketSet = new
    // CopyOnWriteArraySet<MessageWebSocket>();

    private static ConcurrentHashMap<String, Session> connections = new ConcurrentHashMap<>();

    private static ChatServiceImpl chatServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setCharServiceImpl(ChatServiceImpl chatServiceImpl) {
        MessageWebSocket.chatServiceImpl = chatServiceImpl;
    }

    private static MessageServiceImpl messageServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setMessageServiceImpl(MessageServiceImpl messageServiceImpl) {
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

    public static List<Message> getMessages(String session_3rd, List<String> chatids) {
        List<Message> res = new ArrayList<Message>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(messageServiceImpl.getLastMessage(session_3rd, chatids.get(i)));
        }
        return res;
    }

    public static void sendMessages(String session_3rd, Session session) throws IOException {
        List<String> chatids = getChatids(session_3rd);
        List<Message> messages = getMessages(session_3rd, chatids);
        ObjectMapper objectMapper = new ObjectMapper();
        session.getAsyncRemote().sendText(objectMapper.writeValueAsString(messages));
    }

}
