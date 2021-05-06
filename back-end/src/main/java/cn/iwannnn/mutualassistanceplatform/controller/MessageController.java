package cn.iwannnn.mutualassistanceplatform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Message;
import cn.iwannnn.mutualassistanceplatform.service.Impl.ChatServiceImpl;
import cn.iwannnn.mutualassistanceplatform.service.Impl.MessageServiceImpl;

@RestController
@ServerEndpoint("/wx/message/{session_3rd}")
public class MessageController {

    private String session_3rd;

    private static ChatServiceImpl chatServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setCharServiceImpl(ChatServiceImpl chatServiceImpl) {
        MessageController.chatServiceImpl = chatServiceImpl;
    }

    private static MessageServiceImpl messageServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setMessageServiceImpl(MessageServiceImpl messageServiceImpl) {
        MessageController.messageServiceImpl = messageServiceImpl;
    }

    @OnOpen
    public void onOpen(@PathParam("session_3rd") String session_3rd, Session session) throws IOException {
        this.session_3rd = session_3rd;
        System.out.println(this.session_3rd);
        List<String> chatids = getChatids();
        List<Message> messages = getMessages(chatids);
        System.out.println(messages.toString());
        sendMessages(session, messages);
    }

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        System.out.println("服务器接收到的消息：" + message);
        session.getBasicRemote().sendText("服务器回复的消息: " + "Hello，Are you OK?");
    }

    public List<String> getChatids() {
        return chatServiceImpl.getChatids(session_3rd);
    }

    // public List<Chat> getChats(List<String> chatids) {
    // return chatServiceImpl.getChats(chatids);
    // }

    public List<Message> getMessages(List<String> chatids) {
        List<Message> res = new ArrayList<Message>();
        for (int i = 0; i < chatids.size(); i++) {
            res.add(messageServiceImpl.getLastMessage(session_3rd, chatids.get(i)));
        }
        return res;
    }

    public void sendMessages(Session session, List<Message> messages) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        session.getBasicRemote().sendText(objectMapper.writeValueAsString(messages));
    }

}
