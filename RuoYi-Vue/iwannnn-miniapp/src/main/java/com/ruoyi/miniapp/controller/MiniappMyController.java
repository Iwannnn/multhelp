package com.ruoyi.miniapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.miniapp.dto.MiniappMyPost;
import com.ruoyi.miniapp.service.impl.MiniappMyServiceImpl;
import com.ruoyi.miniapp.domain.MiniappAccount;

@RestController
@RequestMapping("/wx/my")
public class MiniappMyController {
    @Autowired
    MiniappMyServiceImpl myServiceImpl;

    @RequestMapping("/getPosts")
    List<MiniappMyPost> getMyPosts(String session_3rd, int nums) {
        return myServiceImpl.getMyPosts(session_3rd, nums);
    }

    @RequestMapping("/getHelps")
    List<MiniappMyPost> getMyHelps(String session_3rd, int nums) {
        return myServiceImpl.getMyHelps(session_3rd, nums);
    }

    @RequestMapping("/getPostDetail")
    MiniappMyPost getPostDetail(String postid) {
        return myServiceImpl.getPostDetail(postid);
    }

    @RequestMapping("/getUsersProfile")
    List<MiniappAccount> getUsersProfile(String postid) {
        return myServiceImpl.getUsersProfile(postid);
    }
}
