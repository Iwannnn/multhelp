package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息界面对象 multhelp_message
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 聊天id */
    @Excel(name = "聊天id")
    private Long chatid;

    /** 最近的聊天内容id */
    @Excel(name = "最近的聊天内容id")
    private Long lastContentid;

    public void setChatid(Long chatid) 
    {
        this.chatid = chatid;
    }

    public Long getChatid() 
    {
        return chatid;
    }
    public void setLastContentid(Long lastContentid) 
    {
        this.lastContentid = lastContentid;
    }

    public Long getLastContentid() 
    {
        return lastContentid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chatid", getChatid())
            .append("lastContentid", getLastContentid())
            .toString();
    }
}
