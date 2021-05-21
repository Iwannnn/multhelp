package com.ruoyi.multhelp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.multhelp.dto.MiniappMyPost;
import com.ruoyi.multhelp.domain.MiniappAccount;
import com.ruoyi.multhelp.mapper.MiniappMyMapper;
import com.ruoyi.multhelp.service.IMiniappMyService;

@Service
public class MiniappMyServiceImpl implements IMiniappMyService {

    @Autowired
    MiniappMyMapper myMapper;

    @Autowired
    MiniappSessionServiceImpl sessionServiceImpl;

    @Autowired
    MiniappAccountServiceImpl accountServiceImpl;

    @Override
    public List<MiniappMyPost> getMyPosts(String session_3rd, int nums) {
        String publish_openid = sessionServiceImpl.getOpenid(session_3rd);
        return myMapper.getPosts("publish_openid", publish_openid, nums);
    }

    @Override
    public List<MiniappMyPost> getMyHelps(String session_3rd, int nums) {
        String receive_openid = sessionServiceImpl.getOpenid(session_3rd);
        return myMapper.getPosts("receive_openid", receive_openid, nums);
    }

    @Override
    public MiniappMyPost getPostDetail(String postid) {
        return myMapper.getPostDetail(postid);
    }

    @Override
    public List<MiniappAccount> getUsersProfile(String postid) {
        List<MiniappAccount> res = new ArrayList<MiniappAccount>();
        String publish_openid;
        String receive_openid;
        publish_openid = myMapper.selectFromPost("publish_openid", postid);
        receive_openid = myMapper.selectFromPost("receive_openid", postid);
        MiniappAccount publish = accountServiceImpl.getUserProfileByOpenid(publish_openid);
        MiniappAccount receive = accountServiceImpl.getUserProfileByOpenid(receive_openid);
        res.add(publish);
        res.add(receive);
        return res;
    }
}
