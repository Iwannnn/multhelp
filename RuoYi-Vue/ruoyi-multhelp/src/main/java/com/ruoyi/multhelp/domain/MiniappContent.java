package com.ruoyi.multhelp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappContent {
    private String contentid;
    @JsonIgnore
    private String send_openid;
    @JsonIgnore
    private String receive_openid;
    private String sender;
    private String content;
    private String create_time;
    private String is_read;

}
