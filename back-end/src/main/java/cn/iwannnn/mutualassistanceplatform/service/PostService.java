package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.dto.PostDetail;
import cn.iwannnn.mutualassistanceplatform.dto.PostMini;
import cn.iwannnn.mutualassistanceplatform.pojo.Post;

public interface PostService {

    void publishPost(Post post);

    List<PostMini> getPostsWithoutCategory(int nums);

    List<PostMini> getPostsWithCategory(String category, int nums);

    PostDetail getPostDetail(String postid);

    boolean receivePost(String session_3rd, String postid);
}
