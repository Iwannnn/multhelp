package cn.iwannnn.mutualassistanceplatform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.iwannnn.mutualassistanceplatform.account.Account;

@RestController
@RequestMapping("/wx")
public class AccountController {
    @RequestMapping(value = "/account_info", method = RequestMethod.POST)
    public void getAccountInfo(@RequestBody Account account) {
        System.out.println(account.getName());
    }

}