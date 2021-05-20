package cn.iwannnn.mutualassistanceplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMini {
    private String postid;
    private String tittle;
    private String category;
    private String price;
    private String address;
    private String create_time;
    private String need_time;
}
