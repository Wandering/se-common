package cn.starteasy.core.common.adminui.backend.domain.dto;

/**
 *
 */
public class RoleDTO {
	private long resourceId;  //本身id
	private String resourceName;
	private long parentResourceId;
	private Object userId;
	
	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
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
	

}
