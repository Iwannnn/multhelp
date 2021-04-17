package cn.iwannnn.mutualassistanceplatform.account;

import cn.iwannnn.mutualassistanceplatform.controller.account.AccountController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile extends Account {
    private String nickname;
    private String avatar_url;
    private String gender;
    private String language;
    private String city;
    private String province;

    // public void saveProfile() {

    // }

    // public static checkProfile(String code){
    // }
}
