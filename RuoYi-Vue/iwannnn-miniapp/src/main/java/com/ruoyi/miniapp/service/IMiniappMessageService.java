package com.ruoyi.miniapp.service;

import com.ruoyi.miniapp.domain.MiniappMessage;

public interface IMiniappMessageService {

    MiniappMessage getLastMessage(String openid, String chatid);
}
