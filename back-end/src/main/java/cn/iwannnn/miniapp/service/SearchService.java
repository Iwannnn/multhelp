package cn.iwannnn.miniapp.service;

import java.util.List;

import cn.iwannnn.miniapp.dto.PostMini;

public interface SearchService {
    List<PostMini> search(String searchValue, int nums);
}
