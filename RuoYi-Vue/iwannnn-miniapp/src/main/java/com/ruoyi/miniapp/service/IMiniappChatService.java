package com.ruoyi.miniapp.service;

import java.util.List;

import com.ruoyi.miniapp.domain.MiniappChat;
import com.ruoyi.miniapp.domain.MiniappContent;

public interface IMiniappChatService {

    String createChat(String session_3rd, String postid);

    List<MiniappContent> getPrevContents(String chatid);

    String checkIdentity(String chatid, String session_3rd);

    List<String> getChatids(String session_3rd);

    List<MiniappChat> getChats(List<String> chatids);

    void isRead(String contentid);

}
