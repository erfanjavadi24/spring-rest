package com.erfan.springrest.student;

import com.erfan.springrest.dao.StudentRepositoryImp;
import com.erfan.springrest.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {
    @Mock
    private StudentRepositoryImp repositoryImp;

    @Test
    public void getTest(){
        //given
        Student student1 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        Student student2 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        List<Student> list = Arrays.asList(student1,student2);
        //when
        when(repositoryImp.getStudents()).thenReturn(list);
        List<Student> studentList = repositoryImp.getStudents();
        //then
        verify(repositoryImp).getStudents();
        assertThat(studentList).size().isEqualTo(2);
    }
}
