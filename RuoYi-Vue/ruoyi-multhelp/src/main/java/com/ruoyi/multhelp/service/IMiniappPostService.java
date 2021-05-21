package com.ruoyi.multhelp.service;

import java.util.List;

import com.ruoyi.multhelp.dto.MiniappPostDetail;
import com.ruoyi.multhelp.dto.MiniappPostMini;
import com.ruoyi.multhelp.domain.Post;

public interface IMiniappPostService {

    void publishPost(Post post);

    List<MiniappPostMini> getPostsWithoutCategory(int nums);

    List<MiniappPostMini> getPostsWithCategory(String category, int nums);

    MiniappPostDetail getPostDetail(String postid);

    boolean receivePost(String session_3rd, String postid);
}
