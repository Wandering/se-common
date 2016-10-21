





/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:10:23 $ 
 */
package cn.starteasy.core.common.adminui.backend.domain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.starteasy.core.common.domain.CreateBaseDomain;

import java.util.*;

public class User extends CreateBaseDomain<Integer>{
    /** 登录名 */
    private String login;
    /** 密码 */
    private String password;
    /** 联系电话 */
    private String phone;
    /** 联系电邮 */
    private String email;
    /** 头像 */
    private String photo;

	public User(){
	}
    public void setLogin(String value) {
        this.login = value;
    }

    public String getLogin() {
        return this.login;
    }
    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPhone(String value) {
        this.phone = value;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public String getEmail() {
        return this.email;
    }
    public void setPhoto(String value) {
        this.photo = value;
    }

    public String getPhoto() {
        return this.photo;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Login",getLogin())
			.append("Password",getPassword())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("Phone",getPhone())
			.append("Email",getEmail())
			.append("Photo",getPhoto())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

