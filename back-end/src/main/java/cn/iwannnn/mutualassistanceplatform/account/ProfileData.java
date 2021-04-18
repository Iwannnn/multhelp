package cn.iwannnn.mutualassistanceplatform.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ProfileData {
    private String nickName;
    private String avatarUrl;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
}
