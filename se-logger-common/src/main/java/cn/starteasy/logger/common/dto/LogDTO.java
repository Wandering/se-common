package cn.starteasy.logger.common.dto;

import cn.starteasy.core.common.domain.BaseDomain;

import java.util.Date;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 16/10/25<br/>
 *
 * @author xule
 * @since v0.0.1
 */
public class LogDTO extends BaseDomain {
    private String uid;//操作人
    private Date operateTime;//操作日期
    private String content;//日志内容
    private String operation;//操作类型(主要是"添加"、"修改"、"删除")

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
