package cn.iwannnn.mutualassistanceplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPost {
    private String postid;
    private String create_time;
    private String need_time;
    private String end_time;
    private String tittle;
    private String address;
    private String price;
    private String detail;
    private String is_value;
}
