package com.erfan.springrest.service;

import com.erfan.springrest.dao.ServiceRepository;
import com.erfan.springrest.entity.ServiceCallLog;
import com.erfan.springrest.rest_controller.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class ServiceLogger {
    @Autowired
    ServiceRepository serviceRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Transactional(propagation = Propagation.REQUIRED)
    public void postSucceedServiceLog(ServiceCallLog serviceCallLog){
        serviceRepository.save(serviceCallLog);
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("log:Current transaction name: " + currentTransactionName);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void postFailedServiceLog(ServiceCallLog serviceCallLog){
        logger.info("hey i'm here in postFailedServiceLog");
        serviceRepository.save(serviceCallLog);
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("log:Current transaction name: " + currentTransactionName);
    }
}