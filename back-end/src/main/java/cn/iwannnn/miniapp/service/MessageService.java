package cn.iwannnn.miniapp.service;

import cn.iwannnn.miniapp.domain.Message;

public interface MessageService {

    Message getLastMessage(String session_3rd, String chatid);
}
