package com.erfan.springrest.student;

import com.erfan.springrest.dao.StudentRepositoryImp;
import com.erfan.springrest.entity.Student;
import com.erfan.springrest.service.StudentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepositoryImp repositoryImp;
    @InjectMocks
    StudentService service;


    @Test
    public void getStudent(){
        //given
        Student student1 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        Student student2 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        List<Student> list = Arrays.asList(student1,student2);

        when(repositoryImp.getStudents()).thenReturn(list);

        //when
        List<Student> studentList = service.getStudents();

        //then
        verify(repositoryImp).getStudents();
        assertThat(list).isEqualTo(studentList);
        assertThat(studentList).size().isEqualTo(2);
    }

    @Test
    public void addStudent(){
        //given
        Student student = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        //when
        if (student.getAge() < 5){
            assertThatThrownBy(() -> {
                service.postStudent(student);
            }).isInstanceOf(RuntimeException.class).hasMessageContaining("illegal age exception");
        }else{
            service.postStudent(student);
        }
        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(repositoryImp).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }
}
