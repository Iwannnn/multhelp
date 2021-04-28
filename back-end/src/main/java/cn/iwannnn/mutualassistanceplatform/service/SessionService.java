package cn.iwannnn.mutualassistanceplatform.service;

public interface SessionService {

    public String getOpenid(String session_3rd);

    public boolean checkSession_3rd(String session_3rd);
}
