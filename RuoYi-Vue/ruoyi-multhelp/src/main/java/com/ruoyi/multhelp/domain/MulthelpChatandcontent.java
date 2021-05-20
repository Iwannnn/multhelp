package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聊天会话连接对象 multhelp_chatandcontent
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpChatandcontent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 聊天id */
    @Excel(name = "聊天id")
    private Long chatid;

    /** 聊天内容id */
    @Excel(name = "聊天内容id")
    private Long contentid;

    public void setChatid(Long chatid) 
    {
        this.chatid = chatid;
    }

    public Long getChatid() 
    {
        return chatid;
    }
    public void setContentid(Long contentid) 
    {
        this.contentid = contentid;
    }

    public Long getContentid() 
    {
        return contentid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chatid", getChatid())
            .append("contentid", getContentid())
            .toString();
    }
}
