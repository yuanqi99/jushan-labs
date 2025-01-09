
package com.jushan.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order
@Component
@Slf4j
public class LogAop
{

    @Pointcut("@annotation(com.jushan.aop.Log)")
    private void getLogPointCut() {
    }

    @AfterReturning(pointcut = "getLogPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log loger = method.getAnnotation(Log.class);
        for (Object arg : args)
        {
            log.info("AfterReturning 參數操作日志：{}  ---{}",loger.value(), JSONUtil.toJsonStr(arg));
        }
        log.info("AfterReturning 返回操作日志：{} -----{}",loger.value(), JSONUtil.toJsonStr(result));
    }


    @AfterThrowing(pointcut = "getLogPointCut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log loger = method.getAnnotation(Log.class);
        for (Object arg : args)
        {
           log.info("操作日志：{}  ---{}",loger.value(), JSONUtil.toJsonStr(arg));
        }
        //异步记录日志
        log.error("操作日志：{} ----{}",loger.value(), JSONUtil.toJsonStr(exception));;
    }
}
