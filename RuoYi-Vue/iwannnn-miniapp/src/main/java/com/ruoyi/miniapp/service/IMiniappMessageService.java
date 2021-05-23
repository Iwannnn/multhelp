package com.ruoyi.miniapp.service;

import com.ruoyi.miniapp.domain.MiniappMessage;

public interface IMiniappMessageService {

    MiniappMessage getLastMessage(String session_3rd, String chatid);
}
