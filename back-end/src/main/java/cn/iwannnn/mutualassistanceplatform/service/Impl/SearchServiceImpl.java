package cn.iwannnn.mutualassistanceplatform.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.mutualassistanceplatform.dto.PostMini;
import cn.iwannnn.mutualassistanceplatform.mapper.SearchMapper;
import cn.iwannnn.mutualassistanceplatform.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<PostMini> search(String searchValue, int nums) {
        return searchMapper.search(searchValue, nums);
    }

}
