package cn.iwannnn.mutualassistanceplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.entity.PostMini;

@Service
public interface SearchService {
    List<PostMini> search(String searchValue, int nums);
}
