package cn.iwannnn.mutualassistanceplatform.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.iwannnn.mutualassistanceplatform.entity.Content;
import cn.iwannnn.mutualassistanceplatform.service.Impl.ContentServiceImpl;

@ServerEndpoint("/wx/chat/{chatid}")
@Component
public class ContentWebSocket {

    private String chatid;

    private Session session;

    private static ContentServiceImpl contentServiceImpl;// 由于websocket的冲突 绑定方式要改变 不然会有null的异常

    @Autowired
    public void setContentServiceImpl(ContentServiceImpl contentServiceImpl) {
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
        Content contentBack = contentServiceImpl.createContent(chatid, session_3rd, content);
        MessageWebSocket.sendData(session_3rd);
        sendMessage(contentBack);
    }

    public void sendMessage(Content content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.session.getAsyncRemote().sendText(objectMapper.writeValueAsString(content));
    }

}