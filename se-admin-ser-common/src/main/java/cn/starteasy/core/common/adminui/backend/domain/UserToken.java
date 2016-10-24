





/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:10:24 $ 
 */
package cn.starteasy.core.common.adminui.backend.domain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.starteasy.core.common.domain.BaseDomain;

import java.util.*;

public class UserToken extends BaseDomain<Integer>{
    /** 序列号 */
    private String series;
    /** token */
    private String tokenValue;
    /** 生成时间 */
    private Long tokenDate;
    /** 访问ip */
    private String ipAddress;
    /** 访问浏览器 */
    private String userAgent;
    /** 用户ID */
    private Long userId;
    /** 用户登录名 */
    private String userLogin;

	public UserToken(){
	}
    public void setSeries(String value) {
        this.series = value;
    }

    public String getSeries() {
        return this.series;
    }
    public void setTokenValue(String value) {
        this.tokenValue = value;
    }

    public String getTokenValue() {
        return this.tokenValue;
    }
    public void setTokenDate(Long value) {
        this.tokenDate = value;
    }

    public Long getTokenDate() {
        return this.tokenDate;
    }
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }
    public void setUserAgent(String value) {
        this.userAgent = value;
    }

    public String getUserAgent() {
        return this.userAgent;
    }
    public void setUserId(Long value) {
        this.userId = value;
    }

    public Long getUserId() {
        return this.userId;
    }
    public void setUserLogin(String value) {
        this.userLogin = value;
    }

    public String getUserLogin() {
        return this.userLogin;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Series",getSeries())
			.append("TokenValue",getTokenValue())
			.append("TokenDate",getTokenDate())
			.append("IpAddress",getIpAddress())
			.append("UserAgent",getUserAgent())
			.append("UserId",getUserId())
			.append("UserLogin",getUserLogin())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserToken == false) return false;
		if(this == obj) return true;
		UserToken other = (UserToken)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

