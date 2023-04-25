package com.erfan.springrest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.erfan.springrest.dao.ServiceRepository;
import com.erfan.springrest.entity.ServiceCallLog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ServiceLogger.class})
@ExtendWith(SpringExtension.class)
class ServiceLoggerTest {
    @Autowired
    private ServiceLogger serviceLogger;

    @MockBean
    private ServiceRepository serviceRepository;

    /**
     * Method under test: {@link ServiceLogger#postSucceedServiceLog(ServiceCallLog)}
     */
    @Test
    void testPostSucceedServiceLog() {
        ServiceCallLog serviceCallLog = new ServiceCallLog();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        serviceCallLog.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        serviceCallLog.setErrorMessage("An error occurred");
        serviceCallLog.setId(1);
        serviceCallLog.setServiceName("Service Name");
        serviceCallLog.setSucceed(true);
        when(serviceRepository.save((ServiceCallLog) any())).thenReturn(serviceCallLog);

        ServiceCallLog serviceCallLog1 = new ServiceCallLog();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        serviceCallLog1.setDate(fromResult);
        serviceCallLog1.setErrorMessage("An error occurred");
        serviceCallLog1.setId(1);
        serviceCallLog1.setServiceName("Service Name");
        serviceCallLog1.setSucceed(true);
        serviceLogger.postSucceedServiceLog(serviceCallLog1);
        verify(serviceRepository).save((ServiceCallLog) any());
        assertSame(fromResult, serviceCallLog1.getDate());
        assertTrue(serviceCallLog1.getSucceed());
        assertEquals("Service Name", serviceCallLog1.getServiceName());
        assertEquals(1, serviceCallLog1.getId());
        assertEquals("An error occurred", serviceCallLog1.getErrorMessage());
    }

    /**
     * Method under test: {@link ServiceLogger#postFailedServiceLog(ServiceCallLog)}
     */
    @Test
    void testPostFailedServiceLog() {
        ServiceCallLog serviceCallLog = new ServiceCallLog();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        serviceCallLog.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        serviceCallLog.setErrorMessage("An error occurred");
        serviceCallLog.setId(1);
        serviceCallLog.setServiceName("Service Name");
        serviceCallLog.setSucceed(true);
        when(serviceRepository.save((ServiceCallLog) any())).thenReturn(serviceCallLog);

        ServiceCallLog serviceCallLog1 = new ServiceCallLog();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        serviceCallLog1.setDate(fromResult);
        serviceCallLog1.setErrorMessage("An error occurred");
        serviceCallLog1.setId(1);
        serviceCallLog1.setServiceName("Service Name");
        serviceCallLog1.setSucceed(true);
        serviceLogger.postFailedServiceLog(serviceCallLog1);
        verify(serviceRepository).save((ServiceCallLog) any());
        assertSame(fromResult, serviceCallLog1.getDate());
        assertTrue(serviceCallLog1.getSucceed());
        assertEquals("Service Name", serviceCallLog1.getServiceName());
        assertEquals(1, serviceCallLog1.getId());
        assertEquals("An error occurred", serviceCallLog1.getErrorMessage());
    }
}

