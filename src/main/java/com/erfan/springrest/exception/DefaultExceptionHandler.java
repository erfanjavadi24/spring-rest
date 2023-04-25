package com.erfan.springrest.exception;

import com.erfan.springrest.entity.ServiceCallLog;
import com.erfan.springrest.service.ServiceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@ControllerAdvice
public class DefaultExceptionHandler{

    @Autowired
    ServiceLogger serviceLogger;


    @ExceptionHandler(value = IllegalAgeException.class)
    public ResponseEntity<Object> handleIllegalAgeException(IllegalAgeException e){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        serviceLogger.postFailedServiceLog(new ServiceCallLog("saveStudent", false, new Date(),"illegal age!"));
        return new ResponseEntity<>(apiException,status);
    }
}