package com.erfan.springrest.dao;

import com.erfan.springrest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Repository
@Transactional
public class StudentRepositoryImp implements StudentRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Student> getStudents(){
        Query query = entityManager.createQuery("SELECT s FROM Student s",Student.class);
        List<Student> students = query.getResultList();
        System.out.println(students);
        return students;
    }
    @Override
    public Student getStudentById(int id){
        return entityManager.find(Student.class,id);
    }
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(Student student) {
             entityManager.persist(student);
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("student:Current transaction name: " + currentTransactionName);
             //throw new RuntimeException("something went wrong!");
//            Random random = new Random();
//            if (random.nextBoolean()) {
//                throw new RuntimeException("something went wrong!");
//            }
    }
}
