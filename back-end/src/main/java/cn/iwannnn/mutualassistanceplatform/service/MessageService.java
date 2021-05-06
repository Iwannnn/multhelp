package cn.iwannnn.mutualassistanceplatform.service;

import cn.iwannnn.mutualassistanceplatform.entity.Message;

public interface MessageService {

    Message getLastMessage(String session_3rd, String chatid);
}
