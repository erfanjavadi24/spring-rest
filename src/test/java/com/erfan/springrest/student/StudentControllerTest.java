package com.erfan.springrest.student;

import com.erfan.springrest.entity.Student;
import com.erfan.springrest.rest_controller.StudentController;
import com.erfan.springrest.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Test
    public void getStudents() throws Exception {
        // Setup
        Student student1 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        Student student2 = new Student(1,"reza","shamsfar@gmail.com",22,new Date());
        List<Student> list = Arrays.asList(student1,student2);

        when(service.getStudents()).thenReturn(list);
        // Test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
        // Verify
        verify(service, times(1)).getStudents();
    }
}
