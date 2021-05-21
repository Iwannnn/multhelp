package cn.iwannnn.miniapp.service;

import java.util.List;

import cn.iwannnn.miniapp.dto.MyPost;
import cn.iwannnn.miniapp.pojo.Account;

public interface MyService {
    List<MyPost> getMyPosts(String session_3rd, int nums);

    List<MyPost> getMyHelps(String session_3rd, int nums);

    MyPost getPostDetail(String postid);

    List<Account> getUsersProfile(String postid);

}
