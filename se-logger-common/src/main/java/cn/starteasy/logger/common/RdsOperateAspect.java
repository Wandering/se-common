package cn.starteasy.logger.common;

import cn.starteasy.core.common.domain.UserDomain;
import cn.starteasy.core.common.utils.UserContext;
import cn.starteasy.logger.common.dto.LogDTO;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * RDS操作日志记录
 * <p/>
 * 创建时间: 16/10/25<br/>
 *
 * @author xule
 * @since v0.0.1
 */
@Aspect
public class RdsOperateAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    /**
     * 切入点
     */
    @Pointcut("execution(* cn.starteasy.core.common.dao.*.insert*(..))")
    public void insertDAOCall() {
    }

    @Pointcut("execution(* cn.starteasy.core.common.dao.*.save*(..))")
    public void saveDAOCall() {
    }

    @Pointcut("execution(* cn.starteasy.core.common.dao.*.update*(..))")
    public void updateDAOCall() {
    }

    @Pointcut("execution(* cn.starteasy.core.common.dao.*.delete*(..))")
    public void deleteDAOCall() {
    }

    /**
     * 返回后通知
     */
    @AfterReturning(value = "insertDAOCall()")
    public void insertDAOCallCalls(JoinPoint joinPoint) throws Throwable {
        logOperate(joinPoint, RdsOperateEnum.C);
    }

    @AfterReturning(value = "saveDAOCall()")
    public void saveDAOCallCalls(JoinPoint joinPoint) throws Throwable {
        logOperate(joinPoint, RdsOperateEnum.C);
    }

    @AfterReturning(value = "updateDAOCall()")
    public void updateDAOCallCalls(JoinPoint joinPoint) throws Throwable {
        logOperate(joinPoint, RdsOperateEnum.U);
    }

    @AfterReturning(value = "deleteDAOCall()")
    public void deleteDAOCallCalls(JoinPoint joinPoint) throws Throwable {
        logOperate(joinPoint, RdsOperateEnum.D);
    }

    /**
     * 日志记录
     * @param joinPoint
     * @param operateEnum
     * @throws Throwable
     */
    private void logOperate(JoinPoint joinPoint, RdsOperateEnum operateEnum) throws Throwable {
        UserDomain user = UserContext.getCurrentUser();
        if (user == null) {
            return;
        }
        String uid = String.valueOf(user.getId());

        if (joinPoint.getArgs() == null) {//没有参数
            return;
        }

        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取操作内容
        String opContent = operateContent(joinPoint.getArgs(), methodName);

        LogDTO log = new LogDTO();
        log.setUid(uid);
        log.setOperateTime(new Date());
        log.setContent(opContent);
        log.setOperation(operateEnum.value());

        logger.debug(JSON.toJSONString(log));
    }

    /**
     * 获取被拦截方法(insert、update、delete)的参数值，将参数值拼接为操作内容
     */
    private String operateContent(Object[] args, String mName) throws Exception {

        if (args == null) {
            return null;
        }

        StringBuffer rs = new StringBuffer();
        rs.append(mName);
        String className = null;
        int index = 1;
        // 遍历参数对象
        for (Object info : args) {

            //获取对象类型
            className = info.getClass().getName();
            className = className.substring(className.lastIndexOf(".") + 1);
            rs.append("[参数" + index + "，类型：" + className + "，值：");

            // 获取对象的所有方法
            Method[] methods = info.getClass().getDeclaredMethods();

            // 遍历方法，判断get方法
            for (Method method : methods) {

                String methodName = method.getName();
                // 判断是不是get方法
                if (methodName.indexOf("get") == -1) {// 不是get方法
                    continue;// 不处理
                }

                Object rsValue = null;
                try {
                    // 调用get方法，获取返回值
                    rsValue = method.invoke(info);
                    if (rsValue == null) {//没有返回值
                        continue;
                    }
                } catch (Exception e) {
                    continue;
                }
                //将值加入内容中
                rs.append("(" + methodName + " : " + rsValue + ")");
            }
            rs.append("]");
            index++;
        }
        return rs.toString();
    }
}

