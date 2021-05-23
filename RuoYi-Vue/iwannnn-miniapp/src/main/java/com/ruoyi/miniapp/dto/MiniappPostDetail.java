package com.ruoyi.miniapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappPostDetail {

    private String nickName;
    private String avatarUrl;
    private String gender;
    private String language;
    private String tittle;
    private String detail;
    private String category;
    private String address;
    private String price;
    private String phone;
    private String create_time;
    private String need_time;
}
