package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerRestTemplateTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }
    @Test
    void studentTest() throws Exception {
        Student student = new Student();
        student.setName("Name");
        student.setAge(12);

        //get
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student",Student[].class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student?id=2",Student[].class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/student?to=2&from=36",Student[].class))
                .isNotNull();
        //post
        Assertions.assertThat(this.restTemplate.postForEntity("http://localhost:"+port+"/student",student,Student.class))
                .isNotNull();
        //delete
      //  Assertions.assertThat(this.restTemplate.delete("http://localhost:"+port+"/student/"+student.getId());

    }
}