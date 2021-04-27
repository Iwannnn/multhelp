package cn.iwannnn.mutualassistanceplatform.controller;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.bind.annotation.RestController;

@RestController
@ServerEndpoint("/wx/chat/content/{contentid}")
public class ContentController {
    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        System.out.println("服务器接收到的消息：" + message);
        session.getBasicRemote().sendText("服务器回复的消息: " + "Hello，Are you OK?");
    }
}