package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import cn.iwannnn.mutualassistanceplatform.dto.PostMini;

public interface SearchService {
    List<PostMini> search(String searchValue, int nums);
}
