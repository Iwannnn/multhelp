package cn.iwannnn.miniapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatAndContent {
    private String chatid;
    private String contentid;
}
