package com.ruoyi.multhelp.service;

import com.ruoyi.multhelp.domain.MiniappMessage;

public interface IMessageService {

    MiniappMessage getLastMessage(String session_3rd, String chatid);
}
