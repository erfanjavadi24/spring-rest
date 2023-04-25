package com.erfan.springrest.dao;

import com.erfan.springrest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository {

    public void save(Student student);
    public List<Student> getStudents();
    public Student getStudentById(int id);

}
