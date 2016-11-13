





/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: se-common
 * $Id:  2016-11-13 15:07:13 $ 
 */
package cn.starteasy.core.common.adminui.backend.domain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.starteasy.core.common.domain.CreateBaseDomain;

import java.util.*;

public class ResourceSearch extends CreateBaseDomain<Integer>{
    /** 资源id */
    private Integer resId;
    /** 查询字段 */
    private String searchField;
    /**  显示名称 */
    private String displayName;
    /** 编辑器类型 */
    private String edittype;
    /** 数据sql|异步请求数据的sql */
    private String valSql;
    /** 顺序号 */
    private Integer orderNum;
    /** 显示的宽度 */
    private Integer width;
    /** 是否可编辑|false,编辑页面不显示 */
    private String editable;
    /** json */
    private String editoptions;
    /** 校验规则|提交到服务器前的有效性校验 */
    private String editrules;
    /** 格式化函数 */
    private String formatter;
    /** 格式化参数json */
    private String formatoptions;
    /** 扩展编辑器 */
    private String unformat;
    /** 隐藏|1列表和编辑页面都不显示 */
    private Integer hide;
    /** 不可编辑|编辑页面不可编辑，但在表格和编辑页面显示 */
    private Integer unedit;
    /** 描述 */
    private String description;
    /** 模块名称 */
    private String moduleName;

	public ResourceSearch(){
	}
    public void setResId(Integer value) {
        this.resId = value;
    }

    public Integer getResId() {
        return this.resId;
    }
    public void setSearchField(String value) {
        this.searchField = value;
    }

    public String getSearchField() {
        return this.searchField;
    }
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    public String getDisplayName() {
        return this.displayName;
    }
    public void setEdittype(String value) {
        this.edittype = value;
    }

    public String getEdittype() {
        return this.edittype;
    }
    public void setValSql(String value) {
        this.valSql = value;
    }

    public String getValSql() {
        return this.valSql;
    }
    public void setOrderNum(Integer value) {
        this.orderNum = value;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }
    public void setWidth(Integer value) {
        this.width = value;
    }

    public Integer getWidth() {
        return this.width;
    }
    public void setEditable(String value) {
        this.editable = value;
    }

    public String getEditable() {
        return this.editable;
    }
    public void setEditoptions(String value) {
        this.editoptions = value;
    }

    public String getEditoptions() {
        return this.editoptions;
    }
    public void setEditrules(String value) {
        this.editrules = value;
    }

    public String getEditrules() {
        return this.editrules;
    }
    public void setFormatter(String value) {
        this.formatter = value;
    }

    public String getFormatter() {
        return this.formatter;
    }
    public void setFormatoptions(String value) {
        this.formatoptions = value;
    }

    public String getFormatoptions() {
        return this.formatoptions;
    }
    public void setUnformat(String value) {
        this.unformat = value;
    }

    public String getUnformat() {
        return this.unformat;
    }
    public void setHide(Integer value) {
        this.hide = value;
    }

    public Integer getHide() {
        return this.hide;
    }
    public void setUnedit(Integer value) {
        this.unedit = value;
    }

    public Integer getUnedit() {
        return this.unedit;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    public String getModuleName() {
        return this.moduleName;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ResId",getResId())
			.append("SearchField",getSearchField())
			.append("DisplayName",getDisplayName())
			.append("Edittype",getEdittype())
			.append("ValSql",getValSql())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.append("Status",getStatus())
			.append("OrderNum",getOrderNum())
			.append("Width",getWidth())
			.append("Editable",getEditable())
			.append("Editoptions",getEditoptions())
			.append("Editrules",getEditrules())
			.append("Formatter",getFormatter())
			.append("Formatoptions",getFormatoptions())
			.append("Unformat",getUnformat())
			.append("Hide",getHide())
			.append("Unedit",getUnedit())
			.append("Description",getDescription())
			.append("ModuleName",getModuleName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ResourceSearch == false) return false;
		if(this == obj) return true;
		ResourceSearch other = (ResourceSearch)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

