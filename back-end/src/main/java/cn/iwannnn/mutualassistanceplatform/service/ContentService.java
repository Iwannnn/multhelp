package cn.iwannnn.mutualassistanceplatform.service;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Content;

@Service
public interface ContentService {

    Content createContent(String chatid, String session_3rd, String content);

}
