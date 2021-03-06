package com.ruoyi.miniapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.miniapp.dto.MiniappPostDetail;
import com.ruoyi.miniapp.dto.MiniappPostMini;
import com.ruoyi.miniapp.domain.MiniappPost;
import com.ruoyi.miniapp.service.impl.MiniappPostServiceImpl;

@RestController
@RequestMapping("/wx/post")
public class MiniappPostController {

    @Autowired
    MiniappPostServiceImpl postServiceImpl;

    @RequestMapping("publishPost")
    public void publishPost(@RequestBody MiniappPost post) {
        postServiceImpl.publishPost(post);
    }

    @RequestMapping("getPostsWithoutCategory")
    public List<MiniappPostMini> getPostsWithoutCategory(int nums) {
        System.out.println(nums);
        return postServiceImpl.getPostsWithoutCategory(nums);
    }

    @RequestMapping("getPostsWithCategory")
    public List<MiniappPostMini> getPostsWithCategory(String category, int nums) {
        return postServiceImpl.getPostsWithCategory(category, nums);
    }

    @RequestMapping("getPostDetail")
    public MiniappPostDetail getPostDetail(String postid) {
        return postServiceImpl.getPostDetail(postid);
    }

    @RequestMapping("helpPost")
    public boolean helpPost(String session_3rd, String postid) {
        return postServiceImpl.receivePost(session_3rd, postid);
    }
}
