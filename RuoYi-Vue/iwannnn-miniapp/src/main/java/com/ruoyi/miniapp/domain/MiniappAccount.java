package com.ruoyi.miniapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappAccount {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String openid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String session_3rd;

    private String nickName;
    private String avatarUrl;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
}
