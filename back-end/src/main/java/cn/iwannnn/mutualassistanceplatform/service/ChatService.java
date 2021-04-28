package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.Content;

public interface ChatService {
    String createChat(String session_3rd, String postid);

    List<Content> getPrevContents(String chatid);
}
