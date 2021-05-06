package cn.iwannnn.mutualassistanceplatform.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.iwannnn.mutualassistanceplatform.entity.Message;
import cn.iwannnn.mutualassistanceplatform.service.Impl.ChatServiceImpl;
import cn.iwannnn.mutualassistanceplatform.service.Impl.MessageServiceImpl;

@ServerEndpoint("/wx/message/{session_3rd}")
@Component
public class MessageWebSocket {

    private String session_3rd;

    private Session session;

    private static ChatServiceImpl chatServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    private static CopyOnWriteArraySet<MessageWebSocket> webSocketSet = new CopyOnWriteArraySet<MessageWebSocket>();

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
        this.session_3rd = session_3rd;
        this.session = session;
        webSocketSet.add(this);
        System.out.println("new message websocket " + this.session);
        sendMessages();
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("close messageWebScoket");
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
    }

    public static void sendData(String session_3rd) throws IOException {
        for (MessageWebSocket item : webSocketSet) {
            if (item.session_3rd.equals(session_3rd))
                item.sendMessages();
        }
    }

    public List<String> getChatids() {
        return chatServiceImpl.getChatids(session_3rd);
    }

    public List<Message> getMessages(List<String> chatids) {
        List<Message> res = new ArrayList<Message>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(messageServiceImpl.getLastMessage(session_3rd, chatids.get(i)));
        }
        return res;
    }

    public void sendMessages() throws IOException {
        List<String> chatids = getChatids();
        List<Message> messages = getMessages(chatids);
        ObjectMapper objectMapper = new ObjectMapper();
        this.session.getAsyncRemote().sendText(objectMapper.writeValueAsString(messages));
    }

}
