package cn.starteasy.core.common.adminui.backend.domain.dto;

public class AssignDetailDTO {

    private int parentResourceId;
    private int resourceId;
    private boolean isFunc;

    public int getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(int parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isFunc() {
        return isFunc;
    }

    public void setIsFunc(boolean isFunc) {
        this.isFunc = isFunc;
    }
}
