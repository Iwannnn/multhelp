package cn.iwannnn.miniapp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String chatid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String last_contentid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String myOpenid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String otherOpenid;

    private String nickName;
    private String avatarUrl;
    private String gender;

    private String lastContent;
    private String lastContentTime;

    private String unread;
}
