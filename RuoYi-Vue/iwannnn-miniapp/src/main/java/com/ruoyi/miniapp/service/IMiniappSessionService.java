package com.ruoyi.miniapp.service;

public interface IMiniappSessionService {

    public String getOpenid(String session_3rd);

    public boolean checkSession_3rd(String session_3rd);
}
