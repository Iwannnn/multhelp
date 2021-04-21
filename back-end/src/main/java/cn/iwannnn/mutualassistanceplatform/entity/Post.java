package cn.iwannnn.mutualassistanceplatform.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String session_3rd;

    private String release_openid;
    private String tittle;
    private String detail;
    private String category;
    private String address;
    private String price;
    private String phone;
    private String need_time;
}
