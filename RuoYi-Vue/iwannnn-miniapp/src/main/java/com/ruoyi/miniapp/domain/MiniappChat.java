package com.ruoyi.miniapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniappChat {
    private String chatid;
    private String initiator_openid;
    private String invitee_openid;
    private String create_time;
}
