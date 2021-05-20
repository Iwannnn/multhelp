package cn.iwannnn.mutualassistanceplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.dto.MyPost;
import cn.iwannnn.mutualassistanceplatform.pojo.Account;
import cn.iwannnn.mutualassistanceplatform.service.Impl.MyServiceImpl;

@RestController
@RequestMapping("wx/my")
public class MyController {
    @Autowired
    MyServiceImpl myServiceImpl;

    @RequestMapping("/getPosts")
    List<MyPost> getMyPosts(String session_3rd, int nums) {
        return myServiceImpl.getMyPosts(session_3rd, nums);
    }

    @RequestMapping("/getHelps")
    List<MyPost> getMyHelps(String session_3rd, int nums) {
        return myServiceImpl.getMyHelps(session_3rd, nums);
    }

    @RequestMapping("/getPostDetail")
    MyPost getPostDetail(String postid) {
        return myServiceImpl.getPostDetail(postid);
    }

    @RequestMapping("/getUsersProfile")
    List<Account> getUsersProfile(String postid) {
        return myServiceImpl.getUsersProfile(postid);
    }
}
