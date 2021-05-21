package cn.iwannnn.miniapp.service;

import cn.iwannnn.miniapp.pojo.Message;

public interface MessageService {

    Message getLastMessage(String session_3rd, String chatid);
}
