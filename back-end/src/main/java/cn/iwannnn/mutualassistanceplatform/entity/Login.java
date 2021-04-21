package cn.iwannnn.mutualassistanceplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private String session_3rd;
    private String openid;
    private String session_key;
}
