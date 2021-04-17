package cn.iwannnn.mutualassistanceplatform.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private static final String APP_ID = "wxb07fbb1d3f12062f";
    private static final String APP_SECRET = "726d441fa159e5c5515f2a67b7e3f5f8";

    private String session_key;
    private String openid;

    public static String getAppID() {
        return APP_ID;
    }

    public static String getAppSecret() {
        return APP_SECRET;
    }
}

      

    
    

    

    

    