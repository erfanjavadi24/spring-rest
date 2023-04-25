package com.erfan.springrest.service;

import com.erfan.springrest.dao.StudentRepositoryImp;
import com.erfan.springrest.entity.ServiceCallLog;
import com.erfan.springrest.entity.Student;
import com.erfan.springrest.exception.IllegalAgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepositoryImp studentRepositoryImp;

    public List<Student> getStudents(){
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
        return studentRepositoryImp.getStudents();
    }
    public Student getStudentById(int id){
        return studentRepositoryImp.getStudentById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void postStudent(Student student){


        studentRepositoryImp.save(student);

        if (student.getAge() < 5) {
            //throw new RuntimeException("illegal age exception");
            throw new IllegalAgeException("illegal age exception");
        }

    }

    public String greet() {
        return "Hello, World";
    }

}
