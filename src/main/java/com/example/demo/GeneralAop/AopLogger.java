package com.example.demo.GeneralAop;


import com.example.demo.Models.Employees;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class AopLogger {

    @Pointcut("execution(* com.example.demo.Controller.*.*(..))")
    public void logginPointCoupur(){
    }
    @Pointcut("execution(* com.example.demo.Controller.EmployeesContoller.getEmployees(..))")
    public void loggingMthodeGetEmploye(){
    }

    @Before("logginPointCoupur()")
    public void beforCallEmployeeControllerMethodes(JoinPoint joinPoint){
        log.info("before call methode of Employee controller :"+joinPoint.getSignature());
    }

    @After("logginPointCoupur()")
    public void afterCallEmployeeControllerMethode(JoinPoint joinPoint){
        log.info("after call : "+joinPoint.getSignature());
    }

    // get the return of methode getEmployees
    @AfterReturning(value = "loggingMthodeGetEmploye()",returning = "returnMethode")
    public void afterReturnin(JoinPoint joinPoint, ResponseEntity<Employees> returnMethode){
        log.info("employe from la methode getEmployer is : "+joinPoint.getSignature());
        log.info(returnMethode.toString());
    }
    @AfterThrowing(value = "logginPointCoupur()",throwing = "exception")
    public void afterReturnin(JoinPoint joinPoint,Exception exception){
        log.info("exception  : "+exception.getMessage());
    }
}
