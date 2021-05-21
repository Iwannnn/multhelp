package com.ruoyi.multhelp.service;

import java.util.List;

import com.ruoyi.multhelp.domain.MiniappChat;
import com.ruoyi.multhelp.domain.MiniappContent;

public interface IMiniappChatService {

    String createChat(String session_3rd, String postid);

    List<MiniappContent> getPrevContents(String chatid);

    String checkIdentity(String chatid, String session_3rd);

    List<String> getChatids(String session_3rd);

    List<MiniappChat> getChats(List<String> chatids);

    void isRead(String contentid);

}
