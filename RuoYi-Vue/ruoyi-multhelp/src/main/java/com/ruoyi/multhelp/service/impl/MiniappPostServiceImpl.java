package com.ruoyi.multhelp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.multhelp.dto.MiniappPostDetail;
import com.ruoyi.multhelp.dto.MiniappPostMini;
import com.ruoyi.multhelp.domain.Post;
import com.ruoyi.multhelp.mapper.MiniappPostMapper;
import com.ruoyi.multhelp.service.IMiniappPostService;

@Service
public class MiniappPostServiceImpl implements IMiniappPostService {

    @Autowired
    private MiniappPostMapper postMapper;

    @Autowired
    private MiniappSessionServiceImpl sessionServiceImpl;

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
    public List<MiniappPostMini> getPostsWithoutCategory(int nums) {
        return postMapper.getPostsWithoutCategory(nums);
    }

    @Override
    public List<MiniappPostMini> getPostsWithCategory(String category, int nums) {
        return postMapper.getPostsWithCategory(category, nums);
    }

    @Override
    public MiniappPostDetail getPostDetail(String postid) {
        String publish_openid = postMapper.selectFromPost("publish_openid", postid);
        return postMapper.getPostDetail(publish_openid, postid);
    }

    @Override
    public boolean receivePost(String session_3rd, String postid) {
        if (!postMapper.isValue(postid))
            return false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String receive_openid = sessionServiceImpl.getOpenid(session_3rd);
        postMapper.updatePost("receive_openid", receive_openid, postid);
        postMapper.updateValue(false, postid);
        postMapper.updatePost("end_time", formatter.format(date), postid);
        return true;
    }

}
