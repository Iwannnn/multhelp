package cn.iwannnn.mutualassistanceplatform.service;

import cn.iwannnn.mutualassistanceplatform.pojo.Message;

public interface MessageService {

    Message getLastMessage(String session_3rd, String chatid);
}
