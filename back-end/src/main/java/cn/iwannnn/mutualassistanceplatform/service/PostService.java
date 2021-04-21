package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.Post;
import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

public interface PostService {

    public void publishPost(Post post);

    public List<PostMini> getPosts(int nums);
}
