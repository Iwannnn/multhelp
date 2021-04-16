package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("wx")
public class HelloWorldController {
    @GetMapping("hello")
    public String sayHello() {
        String hello = "Hello";
        String world = "World";
        List<String> list = new ArrayList<String>();
        list.add(hello);
        list.add(world);
        String res = JSON.toJSONString(list);
        return res;
    }
}