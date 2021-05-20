package com.ruoyi.multhelp.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发布帮助对象 multhelp_post
 * 
 * @author iwannnn
 * @date 2021-05-20
 */
public class MulthelpPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发布帮助id */
    private Integer postid;

    /** 发布人id */
    @Excel(name = "发布人id")
    private String publishOpenid;

    /** 帮助人id */
    @Excel(name = "帮助人id")
    private String receiveOpenid;

    /** 标题 */
    @Excel(name = "标题")
    private String tittle;

    /** 详情 */
    @Excel(name = "详情")
    private String detail;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 价格 */
    @Excel(name = "价格")
    private String price;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 需要时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需要时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date needTime;

    /** 被帮助时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "被帮助时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 是否已经被绑住 */
    @Excel(name = "是否已经被绑住")
    private Integer isValue;

    public void setPostid(Integer postid) 
    {
        this.postid = postid;
    }

    public Integer getPostid() 
    {
        return postid;
    }
    public void setPublishOpenid(String publishOpenid) 
    {
        this.publishOpenid = publishOpenid;
    }

    public String getPublishOpenid() 
    {
        return publishOpenid;
    }
    public void setReceiveOpenid(String receiveOpenid) 
    {
        this.receiveOpenid = receiveOpenid;
    }

    public String getReceiveOpenid() 
    {
        return receiveOpenid;
    }
    public void setTittle(String tittle) 
    {
        this.tittle = tittle;
    }

    public String getTittle() 
    {
        return tittle;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setNeedTime(Date needTime) 
    {
        this.needTime = needTime;
    }

    public Date getNeedTime() 
    {
        return needTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setIsValue(Integer isValue) 
    {
        this.isValue = isValue;
    }

    public Integer getIsValue() 
    {
        return isValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postid", getPostid())
            .append("publishOpenid", getPublishOpenid())
            .append("receiveOpenid", getReceiveOpenid())
            .append("tittle", getTittle())
            .append("detail", getDetail())
            .append("category", getCategory())
            .append("address", getAddress())
            .append("price", getPrice())
            .append("phone", getPhone())
            .append("createTime", getCreateTime())
            .append("needTime", getNeedTime())
            .append("endTime", getEndTime())
            .append("isValue", getIsValue())
            .toString();
    }
}
