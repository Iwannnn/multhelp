package cn.iwannnn.mutualassistanceplatform.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AccountProfile extends Account {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String code;

    private String nickName;
    private String avatarUrl;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
}
