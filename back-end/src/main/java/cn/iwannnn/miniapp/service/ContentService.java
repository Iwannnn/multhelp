package cn.iwannnn.miniapp.service;

import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.domain.Content;

@Service
public interface ContentService {

    Content createContent(String chatid, String session_3rd, String content);

}
