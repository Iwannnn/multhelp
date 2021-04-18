package cn.iwannnn.mutualassistanceplatform.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    protected String nickName;
    protected String avatarUrl;
    protected String gender;
    protected String language;
    protected String city;
    protected String province;
    protected String country;

    @JsonIgnore
    public AccountProfile(Account account) {
        this.openid = account.openid;
        this.session_key = account.session_key;
    }

    @JsonIgnore
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

    @JsonIgnore
    public AccountProfile getProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        AccountProfile res = new AccountProfile();
        try {
            res.setNickName(DatabaseUtils.selectFromDatabase("nickname", table, info.toString()));
            res.setAvatarUrl(DatabaseUtils.selectFromDatabase("avatarUrl", table, info.toString()));
            res.setGender(DatabaseUtils.selectFromDatabase("gender", table, info.toString()));
            res.setLanguage(DatabaseUtils.selectFromDatabase("language", table, info.toString()));
            res.setCity(DatabaseUtils.selectFromDatabase("city", table, info.toString()));
            res.setProvince(DatabaseUtils.selectFromDatabase("province", table, info.toString()));
            res.setCountry(DatabaseUtils.selectFromDatabase("country", table, info.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @JsonIgnore
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

    @JsonIgnore
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
