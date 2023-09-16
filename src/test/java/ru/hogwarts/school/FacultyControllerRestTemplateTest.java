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
    void facultyGet() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty", Faculty[].class))
                .isNotNull();
    }

    @Test
    void facultyGetFromName() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty?name=Воин", Faculty[].class))
                .isNotNull();
    }

    @Test
    void facultyGetFromColor() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty?color=Жёлтый", Faculty[].class))
                .isNotNull();
    }

    @Test
    void facultyPost() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Name");
        faculty.setColor("Color");
        Assertions.assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/faculty", faculty, Faculty.class))
                .isNotNull();
    }

    @Test
    void facultyDelete() throws Exception {
       // Assertions.assertThat(this.restTemplate.delete("http://localhost:" + port + "/faculty/20"));
    }
    @Test
    void facultyPut() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Name");
        faculty.setColor("Color");
        Assertions.assertThat(this.restTemplate.put("http://localhost:" + port + "/faculty", faculty, Faculty.class))
                .isNotNull();
    }
}
