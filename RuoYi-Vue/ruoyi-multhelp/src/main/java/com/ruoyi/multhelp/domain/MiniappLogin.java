package com.ruoyi.multhelp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappLogin {
    @JsonIgnore
    private String session_3rd;

    private String openid;
    private String session_key;
}
