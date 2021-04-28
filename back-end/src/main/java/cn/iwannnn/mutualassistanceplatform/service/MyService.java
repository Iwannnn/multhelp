package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.Account;
import cn.iwannnn.mutualassistanceplatform.entity.MyPost;

public interface MyService {
    List<MyPost> getMyPosts(String session_3rd, int nums);

    List<MyPost> getMyHelps(String session_3rd, int nums);

    MyPost getPostDetail(String postid);

    List<Account> getUsersProfile(String postid);

}