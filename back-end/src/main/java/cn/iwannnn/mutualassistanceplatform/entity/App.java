package cn.iwannnn.mutualassistanceplatform.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class App {
    public static String id = "wxb07fbb1d3f12062f";
    private static String secret = "726d441fa159e5c5515f2a67b7e3f5f8";

    public Login login(String code) {
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");// appid设置
        url.append(id);
        url.append("&secret=");// secret设置
        url.append(secret);
        url.append("&js_code=");// code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        Login login = new Login();
        try {
            HttpClient client = HttpClientBuilder.create().build();// 构建clien
            HttpGet get = new HttpGet(url.toString());// 构建一个get请求
            HttpResponse response = client.execute(get);// 提交get请求
            HttpEntity res = response.getEntity();// 获取返回到HttpResponse的实体
            String content = EntityUtils.toString(res);
            ObjectMapper mapper = new ObjectMapper();
            login = mapper.readValue(content, Login.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
