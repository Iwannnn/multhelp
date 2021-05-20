package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聊天内容对象 multhelp_content
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内容id */
    private Long contentid;

    /** 发送者id */
    @Excel(name = "发送者id")
    private String sendOpenid;

    /** 接收者id */
    @Excel(name = "接收者id")
    private String receiveOpenid;

    /** 发送人 */
    @Excel(name = "发送人")
    private String sender;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 已读 */
    @Excel(name = "已读")
    private Integer isRead;

    public void setContentid(Long contentid) 
    {
        this.contentid = contentid;
    }

    public Long getContentid() 
    {
        return contentid;
    }
    public void setSendOpenid(String sendOpenid) 
    {
        this.sendOpenid = sendOpenid;
    }

    public String getSendOpenid() 
    {
        return sendOpenid;
    }
    public void setReceiveOpenid(String receiveOpenid) 
    {
        this.receiveOpenid = receiveOpenid;
    }

    public String getReceiveOpenid() 
    {
        return receiveOpenid;
    }
    public void setSender(String sender) 
    {
        this.sender = sender;
    }

    public String getSender() 
    {
        return sender;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsRead(Integer isRead) 
    {
        this.isRead = isRead;
    }

    public Integer getIsRead() 
    {
        return isRead;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contentid", getContentid())
            .append("sendOpenid", getSendOpenid())
            .append("receiveOpenid", getReceiveOpenid())
            .append("sender", getSender())
            .append("content", getContent())
            .append("isRead", getIsRead())
            .append("createTime", getCreateTime())
            .toString();
    }
}
