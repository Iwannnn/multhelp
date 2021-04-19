package cn.iwannnn.mutualassistanceplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @JsonIgnore
    private String openid;
    @JsonIgnore
    private String session_key;
}
