package edu.miu.blogpost.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("execution(* edu.miu.blogpost.services.*.*(..)) " +
            "&&" +
            "execution(* edu.miu.blogpost.controller.*.*(..))  ")
    public void allControllerAndServiceMethods(){}

    @Before("allControllerAndServiceMethods()")
    public void logger(JoinPoint joinPoint){
        log.info("Inside method: "+joinPoint.getSignature().getName()
                +" of Class:"+joinPoint.getTarget().getClass().getSimpleName());
    }
}
