package cn.starteasy.logger.common;

/**
 * 数据库操作类型
 * <p/>
 * 创建时间: 16/10/25<br/>
 *
 * @author xule
 * @since v0.0.1
 */
public enum RdsOperateEnum {
    C("C"), U("U"), D("D");
    private String value;

    RdsOperateEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
