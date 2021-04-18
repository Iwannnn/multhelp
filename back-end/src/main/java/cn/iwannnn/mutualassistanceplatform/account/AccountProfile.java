package cn.iwannnn.mutualassistanceplatform.account;

import cn.iwannnn.mutualassistanceplatform.utils.DatabaseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile extends Account {
    private String nickName;
    private String avatarUrl;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;

    public AccountProfile(Account account) {
        this.openid = account.openid;
        this.session_key = account.session_key;
    }

    public void updateProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        try {
            DatabaseUtils.updateDatabase(table, "nickname", nickName, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "avatarurl", avatarUrl, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "gender", gender, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "language", language, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "city", city, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "province", province, "open_id", openid);
            DatabaseUtils.updateDatabase(table, "country", country, "open_id", openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        try {
            DatabaseUtils.selectFromDatabase("nickname", table, info.toString());
            DatabaseUtils.selectFromDatabase("avatarUrl", table, info.toString());
            DatabaseUtils.selectFromDatabase("gender", table, info.toString());
            DatabaseUtils.selectFromDatabase("language", table, info.toString());
            DatabaseUtils.selectFromDatabase("city", table, info.toString());
            DatabaseUtils.selectFromDatabase("province", table, info.toString());
            DatabaseUtils.selectFromDatabase("country", table, info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        String res = null;
        try {
            res = DatabaseUtils.selectFromDatabase("nickname", table, info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res.equals("null") ? false : true;
    }

    public void setProfileData(AccountProfile duplicate) {
        this.avatarUrl = duplicate.avatarUrl;
        this.city = duplicate.city;
        this.country = duplicate.country;
        this.gender = duplicate.gender;
        this.language = duplicate.language;
        this.nickName = duplicate.nickName;
        this.province = duplicate.province;
    }
}
