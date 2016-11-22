





/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: se-common
 * $Id:  2016-11-13 15:07:11 $ 
 */
package cn.starteasy.core.common.adminui.backend.domain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.starteasy.core.common.domain.CreateBaseDomain;

import java.util.*;

public class ResourceDesign extends CreateBaseDomain<Long>{
    /** 编码 */
    private String number;
    /** 资源ID */
    private Long resourceId;
    /** 类型|1页面，2报表 */
    private Integer type;
    /** 图表配置|json格式 */
    private String chartOption;
    /** 查询字段 */
    private String selector;
    /** 显示配置|json格式 */
    private String displayConfig;
    /** 报表sql */
    private String mainSql;
    /** 统计sql|分页要用到 */
    private String mainCountSql;
    /** 查询规则|完全动态化 */
    private String whereRegex;
    private String menuName;
    private String parentName;

	public ResourceDesign(){
	}
    public void setNumber(String value) {
        this.number = value;
    }

    public String getNumber() {
        return this.number;
    }
    public void setResourceId(Long value) {
        this.resourceId = value;
    }

    public Long getResourceId() {
        return this.resourceId;
    }
    public void setType(Integer value) {
        this.type = value;
    }

    public Integer getType() {
        return this.type;
    }
    public void setChartOption(String value) {
        this.chartOption = value;
    }

    public String getChartOption() {
        return this.chartOption;
    }
    public void setSelector(String value) {
        this.selector = value;
    }

    public String getSelector() {
        return this.selector;
    }
    public void setDisplayConfig(String value) {
        this.displayConfig = value;
    }

    public String getDisplayConfig() {
        return this.displayConfig;
    }
    public void setMainSql(String value) {
        this.mainSql = value;
    }

    public String getMainSql() {
        return this.mainSql;
    }
    public void setMainCountSql(String value) {
        this.mainCountSql = value;
    }

    public String getMainCountSql() {
        return this.mainCountSql;
    }
    public void setWhereRegex(String value) {
        this.whereRegex = value;
    }

    public String getWhereRegex() {
        return this.whereRegex;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Number",getNumber())
			.append("ResourceId",getResourceId())
			.append("Type",getType())
			.append("ChartOption",getChartOption())
			.append("Selector",getSelector())
			.append("DisplayConfig",getDisplayConfig())
			.append("MainSql",getMainSql())
			.append("MainCountSql",getMainCountSql())
			.append("WhereRegex",getWhereRegex())
			.append("Status",getStatus())
			.append("Creator",getCreator())
			.append("CreateDate",getCreateDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ResourceDesign == false) return false;
		if(this == obj) return true;
		ResourceDesign other = (ResourceDesign)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

