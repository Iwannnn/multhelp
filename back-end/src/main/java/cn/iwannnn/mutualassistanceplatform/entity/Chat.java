package cn.iwannnn.mutualassistanceplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private String chatid;
    private String initiator_openid;
    private String invitee_openid;
    private String create_time;
}
