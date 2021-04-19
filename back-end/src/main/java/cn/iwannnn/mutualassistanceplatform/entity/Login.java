package cn.iwannnn.mutualassistanceplatform.entity;

import lombok.Data;

@Data
public class Login {
    private String openid;
    private String session_key;
}
