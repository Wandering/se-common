package cn.starteasy.core.common.adminui.backend.domain.dto;


import cn.starteasy.core.common.adminui.backend.domain.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdong on 15/7/31.
 */
public class ResourceDTO extends BaseDTO{

    private Resource resource;
    private List<ResourceDTO> list;

    private long resourceId;  //本身id
    private String resourceName;
    private long parentResourceId;
    private List<ResourceDTO> resourceInfos  = new ArrayList<ResourceDTO>();//子菜单
    private long roleId;
    private String parentResourceName;
    private String orderNum;
    private String url;
    private List<ResourceDTO> resActions  = new ArrayList<ResourceDTO>();//菜单功能
    private Long resourceActionId;
    private String resourceActionName;
    private String actionAlias;

    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    public long getResourceId() {
        return resourceId;
    }
    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public long getParentResourceId() {
        return parentResourceId;
    }
    public void setParentResourceId(long parentResourceId) {
        this.parentResourceId = parentResourceId;
    }
    public List<ResourceDTO> getResourceInfos() {
        return resourceInfos;
    }
    public void setResourceInfos(List<ResourceDTO> resourceInfos) {
        this.resourceInfos = resourceInfos;
    }

    public String getParentResourceName() {
        return parentResourceName;
    }

    public void setParentResourceName(String parentResourceName) {
        this.parentResourceName = parentResourceName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ResourceDTO> getResActions() {
        return resActions;
    }

    public void setResActions(List<ResourceDTO> resActions) {
        this.resActions = resActions;
    }

    public Long getResourceActionId() {
        return resourceActionId;
    }

    public void setResourceActionId(Long resourceActionId) {
        this.resourceActionId = resourceActionId;
    }

    public String getResourceActionName() {
        return resourceActionName;
    }

    public void setResourceActionName(String resourceActionName) {
        this.resourceActionName = resourceActionName;
    }

    public String getActionAlias() {
        return actionAlias;
    }

    public void setActionAlias(String actionAlias) {
        this.actionAlias = actionAlias;
    }

    public List<ResourceDTO> getList() {
        return list;
    }

    public void setList(List<ResourceDTO> list) {
        this.list = list;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
