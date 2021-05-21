package cn.iwannnn.miniapp.service;

import java.util.List;

import cn.iwannnn.miniapp.dto.PostDetail;
import cn.iwannnn.miniapp.dto.PostMini;
import cn.iwannnn.miniapp.domain.Post;

public interface PostService {

    void publishPost(Post post);

    List<PostMini> getPostsWithoutCategory(int nums);

    List<PostMini> getPostsWithCategory(String category, int nums);

    PostDetail getPostDetail(String postid);

    boolean receivePost(String session_3rd, String postid);
}
