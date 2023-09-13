package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerRestTemplateTest {
    @LocalServerPort
    private int port;

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(facultyController).isNotNull();
    }
    @Test
    void facultyTest() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Name");
        faculty.setColor("Color");

        //get
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty", Faculty.class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/Воин",Faculty.class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/faculty/Жёлтый",Faculty.class))
                .isNotNull();
        //post
        Assertions.assertThat(this.restTemplate.postForEntity("http://localhost:"+port+"/faculty",faculty,Faculty.class))
                .isNotNull();
        //delete
        //  Assertions.assertThat(this.restTemplate.delete("http://localhost:"+port+"/faculty/"+student.getId());

    }
}
