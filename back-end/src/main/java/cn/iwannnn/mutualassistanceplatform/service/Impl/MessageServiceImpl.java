package cn.iwannnn.mutualassistanceplatform.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.iwannnn.mutualassistanceplatform.mapper.MessageMapper;
import cn.iwannnn.mutualassistanceplatform.service.MessageService;

public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
}
