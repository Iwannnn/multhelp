package cn.iwannnn.mutualassistanceplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostDetail;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;
import cn.iwannnn.mutualassistanceplatform.service.Impl.PostServiceImpl;

@RestController
@RequestMapping("wx/post")
public class PostController {

    @Autowired
    PostServiceImpl postServiceImpl;

    @RequestMapping("publishPost")
    public void publishPost(@RequestBody Post post) {
        postServiceImpl.publishPost(post);
    }

    @RequestMapping("getPostsWithoutCategory")
    public List<PostMini> getPostsWithoutCategory(int nums) {
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
}
