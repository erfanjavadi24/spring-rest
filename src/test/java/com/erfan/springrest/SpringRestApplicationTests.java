package com.erfan.springrest;

import static org.assertj.core.api.Assertions.assertThat;

import com.erfan.springrest.rest_controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRestApplicationTests {

	@Autowired
	StudentController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
