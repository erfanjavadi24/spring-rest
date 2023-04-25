package com.erfan.springrest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ServiceCallLog {
    @Id
    @SequenceGenerator(
            name = "scl_sequence",
            sequenceName = "scl_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "scl_sequence"
    )
    private int id;
    private String serviceName;
    private Boolean Succeed;
    private String errorMessage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public ServiceCallLog() {
    }


    public ServiceCallLog(String serviceName, Boolean succeed, Date date) {
        this.serviceName = serviceName;
        Succeed = succeed;
        this.date = date;
    }

    public ServiceCallLog(String serviceName, Boolean succeed, Date date,String errorMessage) {
        this.serviceName = serviceName;
        Succeed = succeed;
        this.date = date;
        this.errorMessage = errorMessage;
    }

    public ServiceCallLog(int id, String serviceName, Boolean succeed, Date date, String errorMessage) {
        this.id = id;
        this.serviceName = serviceName;
        Succeed = succeed;
        this.date = date;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getSucceed() {
        return Succeed;
    }

    public void setSucceed(Boolean succeed) {
        Succeed = succeed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
