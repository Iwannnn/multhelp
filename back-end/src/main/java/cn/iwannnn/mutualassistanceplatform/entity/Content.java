package cn.iwannnn.mutualassistanceplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String contentid;
    @JsonIgnore
    private String send_openid;
    @JsonIgnore
    private String receive_openid;
    private String content;
    private String create_time;
    private String is_read;
}
