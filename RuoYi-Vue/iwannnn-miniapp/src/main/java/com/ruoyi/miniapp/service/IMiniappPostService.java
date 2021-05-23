package com.ruoyi.miniapp.service;

import java.util.List;

import com.ruoyi.miniapp.dto.MiniappPostDetail;
import com.ruoyi.miniapp.dto.MiniappPostMini;
import com.ruoyi.miniapp.domain.MiniappPost;

public interface IMiniappPostService {

    void publishPost(MiniappPost post);

    List<MiniappPostMini> getPostsWithoutCategory(int nums);

    List<MiniappPostMini> getPostsWithCategory(String category, int nums);

    MiniappPostDetail getPostDetail(String postid);

    boolean receivePost(String session_3rd, String postid);
}
