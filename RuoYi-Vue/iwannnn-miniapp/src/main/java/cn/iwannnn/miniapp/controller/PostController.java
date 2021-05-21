package cn.iwannnn.miniapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.miniapp.dto.PostDetail;
import cn.iwannnn.miniapp.dto.PostMini;
import cn.iwannnn.miniapp.pojo.Post;
import cn.iwannnn.miniapp.service.Impl.PostServiceImpl;

@RestController
@RequestMapping("wx/post")
@PreAuthorize("@ss.hasAnyRoles('user,admin')")
public class PostController {

    @Autowired
    PostServiceImpl postServiceImpl;

    @RequestMapping("publishPost")
    public void publishPost(@RequestBody Post post) {
        postServiceImpl.publishPost(post);
    }

    @RequestMapping("getPostsWithoutCategory")
    public List<PostMini> getPostsWithoutCategory(int nums) {
        System.out.println(nums);
        return postServiceImpl.getPostsWithoutCategory(nums);
    }

    @RequestMapping("getPostsWithCategory")
    public List<PostMini> getPostsWithCategory(String category, int nums) {
        return postServiceImpl.getPostsWithCategory(category, nums);
    }

    @RequestMapping("getPostDetail")
    public PostDetail getPostDetail(String postid) {
        return postServiceImpl.getPostDetail(postid);
    }

    @RequestMapping("helpPost")
    public boolean helpPost(String session_3rd, String postid) {
        return postServiceImpl.receivePost(session_3rd, postid);
    }
}
