package cn.iwannnn.miniapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.miniapp.dto.PostMini;
import cn.iwannnn.miniapp.service.Impl.SearchServiceImpl;

@RestController
@RequestMapping("wx")
public class SearchController {

    @Autowired
    SearchServiceImpl searchServiceImpl;

    @RequestMapping("search")
    public List<PostMini> search(String searchValue, int nums) {
        return searchServiceImpl.search(searchValue, nums);
    }
}
