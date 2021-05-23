package com.ruoyi.miniapp.service;

import java.util.List;

import com.ruoyi.miniapp.dto.MiniappMyPost;
import com.ruoyi.miniapp.domain.MiniappAccount;

public interface IMiniappMyService {
    List<MiniappMyPost> getMyPosts(String session_3rd, int nums);

    List<MiniappMyPost> getMyHelps(String session_3rd, int nums);

    MiniappMyPost getPostDetail(String postid);

    List<MiniappAccount> getUsersProfile(String postid);

}
