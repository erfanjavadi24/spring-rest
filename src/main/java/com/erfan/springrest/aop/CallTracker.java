package com.erfan.springrest.aop;

import com.erfan.springrest.entity.ServiceCallLog;
import com.erfan.springrest.rest_controller.StudentController;
import com.erfan.springrest.service.ServiceLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;

@Component
@Aspect
public class CallTracker {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private ServiceLogger serviceLogger;
    @Pointcut("execution(* com.erfan.springrest.service.StudentService.postStudent(..))")
    public void logPostStudentService(){

    }

    @AfterReturning("logPostStudentService()")
    public void logAfterStudentSucceed(){
        serviceLogger.postSucceedServiceLog(new ServiceCallLog("saveStudent", true, new Date()));
    }

//    @Around("logPostStudentService()")
//    public Object firstLogAfterExThPostServiceMethod(ProceedingJoinPoint joinPoint){
//        try {
//            Object o = joinPoint.proceed();
//            serviceLogger.postSucceedServiceLog(new ServiceCallLog("saveStudent", true, new Date()));
//            return o;
//        } catch (RuntimeException e) {
//            logger.info("im in aop");
//            serviceLogger.postFailedServiceLog(new ServiceCallLog("saveStudent", false, new Date(),"illegal age!"));
//            throw e;
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//    }
}