package cn.iwannnn.mutualassistanceplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String contendid;
    private String send_openid;
    private String receive_openid;
    private String content;
    private String create_time;
    private String is_read;
}
