package cn.iwannnn.mutualassistanceplatform.account;

import cn.iwannnn.mutualassistanceplatform.utils.DatabaseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private static final String APP_ID = "wxb07fbb1d3f12062f";
    private static final String APP_SECRET = "726d441fa159e5c5515f2a67b7e3f5f8";
    protected static String index = "open_id";
    protected static String table = "account";
    protected String session_key;
    protected String openid;

    public static String getAppID() {
        return APP_ID;
    }

    public static String getAppSecret() {
        return APP_SECRET;
    }

    public void saveOpenID() {
        // System.out.println(ConnectDatabase.insertCmd(table, index, this.openid));
        try {
            DatabaseUtils.insertIntoDatabase(table, index, this.openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkOpenID() {
        StringBuilder info = new StringBuilder("`open_id`= '");
        info.append(this.openid);
        info.append("'");
        String res = null;
        try {
            res = DatabaseUtils.selectFromDatabase(index, table, info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res.equals("") ? false : true;
    }
}
