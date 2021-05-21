package cn.iwannnn.miniapp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.miniapp.dto.PostMini;
import cn.iwannnn.miniapp.mapper.SearchMapper;
import cn.iwannnn.miniapp.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<PostMini> search(String searchValue, int nums) {
        return searchMapper.search(searchValue, nums);
    }

}
