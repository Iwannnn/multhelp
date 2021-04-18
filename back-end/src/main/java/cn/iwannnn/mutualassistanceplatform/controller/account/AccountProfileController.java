package cn.iwannnn.mutualassistanceplatform.controller.account;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.mutualassistanceplatform.account.AccountProfile;

@RestController
@RequestMapping("wx/account")
public class AccountProfileController extends AccountController {

    @RequestMapping("setUserProfile")
    public void setUserProfile(@RequestBody AccountProfile accountProfile) {
        accountProfile.saveProfile();
    }

    @RequestMapping("checkUserProfile")
    public String checkUserProfile(String code) {
        AccountProfile accountProfile = (AccountProfile) getAccount(code);
        if (accountProfile.checkProfile(accountProfile.getOpenid()))
            return "true";
        else
            return "false";
    }

    @RequestMapping("getUserProfile")
    public void getUserProfile(@RequestBody AccountProfile accountProfile) {
        accountProfile.getProfile();
    }

}
