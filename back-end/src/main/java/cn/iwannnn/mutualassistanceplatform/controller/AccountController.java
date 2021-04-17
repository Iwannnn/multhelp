package cn.iwannnn.mutualassistanceplatform.controller;

import cn.iwannnn.mutualassistanceplatform.account.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import java.util.Map;

@RestController
@RequestMapping("wx/account")
public class AccountController {
    @RequestMapping(value = "login")
    public String acocunteLogin(String code) {
        System.out.println(code);
        return code;
    }

}