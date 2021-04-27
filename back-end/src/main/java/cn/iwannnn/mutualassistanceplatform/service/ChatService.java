package cn.iwannnn.mutualassistanceplatform.service;

import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    void createChat(String session_3rd, String postid);
}
