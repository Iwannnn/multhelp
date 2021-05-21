package com.ruoyi.multhelp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappPostMini {
    private String postid;
    private String tittle;
    private String category;
    private String price;
    private String address;
    private String create_time;
    private String need_time;
}
