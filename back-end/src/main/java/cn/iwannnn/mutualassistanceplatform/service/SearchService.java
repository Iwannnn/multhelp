package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

public interface SearchService {
    List<PostMini> search(String searchValue, int nums);
}
