package cn.iwannnn.miniapp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.dto.MyPost;
import cn.iwannnn.miniapp.domain.Account;
import cn.iwannnn.miniapp.mapper.MyMapper;
import cn.iwannnn.miniapp.service.MyService;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    MyMapper myMapper;

    @Autowired
    SessionServiceImpl sessionServiceImpl;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public List<MyPost> getMyPosts(String session_3rd, int nums) {
        String publish_openid = sessionServiceImpl.getOpenid(session_3rd);
        return myMapper.getPosts("publish_openid", publish_openid, nums);
    }

    @Override
    public List<MyPost> getMyHelps(String session_3rd, int nums) {
        String receive_openid = sessionServiceImpl.getOpenid(session_3rd);
        return myMapper.getPosts("receive_openid", receive_openid, nums);
    }

    @Override
    public MyPost getPostDetail(String postid) {
        return myMapper.getPostDetail(postid);
    }

    @Override
    public List<Account> getUsersProfile(String postid) {
        List<Account> res = new ArrayList<Account>();
        String publish_openid;
        String receive_openid;
        publish_openid = myMapper.selectFromPost("publish_openid", postid);
        receive_openid = myMapper.selectFromPost("receive_openid", postid);
        Account publish = accountServiceImpl.getUserProfileByOpenid(publish_openid);
        Account receive = accountServiceImpl.getUserProfileByOpenid(receive_openid);
        res.add(publish);
        res.add(receive);
        return res;
    }
}
