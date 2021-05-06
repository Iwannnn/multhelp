package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.Chat;
import cn.iwannnn.mutualassistanceplatform.entity.Content;

public interface ChatService {

    String createChat(String session_3rd, String postid);

    List<Content> getPrevContents(String chatid);

    String checkIdentity(String chatid, String session_3rd);

    List<String> getChatids(String session_3rd);

    List<Chat> getChats(List<String> chatids);

    void isRead(String contentid);

}
