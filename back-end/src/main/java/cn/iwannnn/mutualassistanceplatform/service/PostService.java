package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostDetail;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

public interface PostService {

    void publishPost(Post post);

    List<PostMini> getPostsWithoutCategory(int nums);

    List<PostMini> getPostsWithCategory(String category, int nums);

    PostDetail getPostDetail(String postid);
}
