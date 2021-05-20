package com.ruoyi.multhelp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户账号对象 multhelp_account
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 微信给的账户id */
    private String openid;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatarurl;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 语言 */
    @Excel(name = "语言")
    private String language;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setAvatarurl(String avatarurl) 
    {
        this.avatarurl = avatarurl;
    }

    public String getAvatarurl() 
    {
        return avatarurl;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public String getLanguage() 
    {
        return language;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("openid", getOpenid())
            .append("nickname", getNickname())
            .append("avatarurl", getAvatarurl())
            .append("gender", getGender())
            .append("language", getLanguage())
            .append("city", getCity())
            .append("province", getProvince())
            .append("country", getCountry())
            .toString();
    }
}
