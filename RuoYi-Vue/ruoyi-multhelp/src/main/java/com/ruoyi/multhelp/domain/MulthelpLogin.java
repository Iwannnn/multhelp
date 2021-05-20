package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登陆验证对象 multhelp_login
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpLogin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 服务器给的临时验证 */
    private String session3rd;

    /** 微信给的id */
    @Excel(name = "微信给的id")
    private String openid;

    /** 微信给的会话key */
    @Excel(name = "微信给的会话key")
    private String sessionKey;

    public void setSession3rd(String session3rd) 
    {
        this.session3rd = session3rd;
    }

    public String getSession3rd() 
    {
        return session3rd;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setSessionKey(String sessionKey) 
    {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() 
    {
        return sessionKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("session3rd", getSession3rd())
            .append("openid", getOpenid())
            .append("sessionKey", getSessionKey())
            .append("createTime", getCreateTime())
            .toString();
    }
}
