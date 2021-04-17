package cn.iwannnn.mutualassistanceplatform.controller.account;

import cn.iwannnn.mutualassistanceplatform.account.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("wx/account")
public class AccountController {

    public Account getAccount(String code) {
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");// appid设置
        url.append(Account.getAppID());
        url.append("&secret=");// secret设置
        url.append(Account.getAppSecret());
        url.append("&js_code=");// code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        Account account = new Account();
        try {
            HttpClient client = HttpClientBuilder.create().build();// 构建clien
            HttpGet get = new HttpGet(url.toString());// 构建一个get请求
            HttpResponse response = client.execute(get);// 提交get请求
            HttpEntity res = response.getEntity();// 获取返回到HttpResponse的实体
            String content = EntityUtils.toString(res);
            ObjectMapper mapper = new ObjectMapper();
            account = mapper.readValue(content, Account.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @RequestMapping(value = "login")
    public void acocunteLogin(String code) {
        Account account = getAccount(code);
        if (!account.checkOpenID())
            account.saveOpenID();
    }

}