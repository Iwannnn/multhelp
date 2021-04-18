package cn.iwannnn.mutualassistanceplatform.account;

import cn.iwannnn.mutualassistanceplatform.utils.ConnectDatabase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfile extends Account {
    private String nickname;
    private String avatar_url;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;

    public void saveProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        try {
            ConnectDatabase.updateDatabase(table, "nickname", nickname, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "avatar_yrl", avatar_url, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "gender", gender, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "language", language, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "city", city, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "province", province, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "country", country, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "nickname", nickname, "open_id", openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getProfile() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        try {
            ConnectDatabase.updateDatabase(table, "nickname", nickname, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "avatar_yrl", avatar_url, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "gender", gender, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "language", language, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "city", city, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "province", province, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "country", country, "open_id", openid);
            ConnectDatabase.updateDatabase(table, "nickname", nickname, "open_id", openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkProfile(String openID) {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        String res = null;
        try {
            res = ConnectDatabase.selectFromDatabase(nickname, table, info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res == null)
            return false;
        else
            return true;
    }
}
