package com.tritonsfs.springboot.annot;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * @author 2018/11/16 15:21 by 刘赵强
 * @desc 目标方法参数顺序必须是：userId,loginToken,callBackFunc
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
@Order(Ordered.HIGHEST_PRECEDENCE)//最高优先级
public @interface ActivityAnnotation {
    /**
     * 活动ID
     * @return
     */
    @NotNull
    String activityId();
    /**
     * 是否验证活动结束
     * @return
     */
    boolean validActivityEnd() default false;

}
