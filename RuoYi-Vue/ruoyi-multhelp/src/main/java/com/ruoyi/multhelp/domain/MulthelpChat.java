package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户聊天对象 multhelp_chat
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpChat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 聊天id */
    private Long chatid;

    /** 发起者 */
    @Excel(name = "发起者")
    private String initiatorOpenid;

    /** 受邀者 */
    @Excel(name = "受邀者")
    private String inviteeOpenid;

    public void setChatid(Long chatid) 
    {
        this.chatid = chatid;
    }

    public Long getChatid() 
    {
        return chatid;
    }
    public void setInitiatorOpenid(String initiatorOpenid) 
    {
        this.initiatorOpenid = initiatorOpenid;
    }

    public String getInitiatorOpenid() 
    {
        return initiatorOpenid;
    }
    public void setInviteeOpenid(String inviteeOpenid) 
    {
        this.inviteeOpenid = inviteeOpenid;
    }

    public String getInviteeOpenid() 
    {
        return inviteeOpenid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chatid", getChatid())
            .append("initiatorOpenid", getInitiatorOpenid())
            .append("inviteeOpenid", getInviteeOpenid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
