package com.example.demo.GeneralAop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopLogger {

    @Pointcut("execution(* com.example.demo.Controller.*.*(..))")
    public void logginPointCoupur(){
    }
    @Before("logginPointCoupur()")
    public void beforCallEmployeeControllerMethodes(JoinPoint joinPoint){
        log.info("before call methode of Employee controller :"+joinPoint.getSignature());
    }

    @After("logginPointCoupur()")
    public void afterCallEmployeeControllerMethode(JoinPoint joinPoint){
        log.info("after call : "+joinPoint.getSignature());
    }
}
