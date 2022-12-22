package com.example.demo.generalAop;


import com.example.demo.domain.Employe;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopLogger {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void logginPointCoupur(){
    }
    @Pointcut("execution(* com.example.demo.controller.EmployeesContoller.getEmployees(..))")
    public void loggingMthodeGetEmploye(){
    }

    // point de coupure sur la methode addEmployee
    @Pointcut("execution(* com.example.demo.controller.EmployeesContoller.addEmployee(..))")
    public void logginAddEmployee(){
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
    public void afterReturnin(JoinPoint joinPoint, ResponseEntity<Employe> returnMethode){
        log.info("employe from la methode getEmployer is : "+joinPoint.getSignature());
        log.info(returnMethode.toString());
    }
    @AfterThrowing(value = "logginPointCoupur()",throwing = "exception")
    public void afterReturnin(JoinPoint joinPoint,Exception exception){
        log.info("exception  : "+exception.getMessage());
    }
    @Around(value = "logginPointCoupur()")
    public Object loggiingAddEmployer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long timeStart =System.currentTimeMillis();
        Object object=proceedingJoinPoint.proceed();
        long endTimeMethode=System.currentTimeMillis();
        log.info("time of execution of "+proceedingJoinPoint.getSignature().getName()+ " methode is :"+(endTimeMethode -timeStart)+" ms");
        return object;
    }
}
