package cn.iwannnn.mutualassistanceplatform.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;
import cn.iwannnn.mutualassistanceplatform.mapper.PostMapper;
import cn.iwannnn.mutualassistanceplatform.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @Override
    public void publishPost(Post post) {
        System.out.println(post);
        String publish_openid = sessionServiceImpl.getOpenid(post.getSession_3rd());
        postMapper.createLine();
        String postid = postMapper.getPostid();
        System.out.println(postid);
        postMapper.updatePost("publish_openid", publish_openid, postid);
        postMapper.updatePost("tittle", post.getTittle(), postid);
        postMapper.updatePost("detail", post.getDetail(), postid);
        postMapper.updatePost("category", post.getCategory(), postid);
        postMapper.updatePost("address", post.getAddress(), postid);
        postMapper.updatePost("price", post.getPrice(), postid);
        postMapper.updatePost("phone", post.getPhone(), postid);
        postMapper.updatePost("need_time", post.getNeed_time(), postid);
    }

    @Override
    public List<PostMini> getPosts(int nums) {
        return postMapper.getPosts(nums);
    }
}
