// package cn.iwannnn.mutualassistanceplatform.controller.account;

// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import org.apache.http.impl.client.HttpClientBuilder;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.client.HttpClient;
// import org.apache.http.HttpResponse;
// import org.apache.http.HttpEntity;
// import org.apache.http.util.EntityUtils;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import cn.iwannnn.mutualassistanceplatform.account.Account;
// import cn.iwannnn.mutualassistanceplatform.account.AccountProfile;

// @RestController
// @RequestMapping("wx/account")
// public class AccountProfileController {

// @RequestMapping("updateUserProfile")
// public void updateUserProfile(@RequestBody AccountProfile accountProfile) {
// accountProfile.updateProfile();
// }

// @RequestMapping("checkUserProfile")
// public static String checkUserProfile(String code) {
// System.out.println(code);
// String openid;
// Account account = AccountController.getAccount(code);
// openid = account.getOpenid();
// System.out.println(openid);
// return "a";
// }

// @RequestMapping("getUserProfile")
// public void getUserProfile(@RequestBody AccountProfile accountProfile) {
// accountProfile.getProfile();
// }

// }
