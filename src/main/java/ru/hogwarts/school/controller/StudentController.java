package ru.hogwarts.school.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.AvatarService;
import ru.hogwarts.school.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    private final AvatarService avatarService;

    public StudentController(StudentService studentService, AvatarService avatarService) {
        this.studentService = studentService;
        this.avatarService = avatarService;
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> get(@RequestParam(required = false) Long id,
                                                   @RequestParam(required = false) Integer to,
                                                   @RequestParam(required = false) Integer from) {
        if (id != null) {
            return ResponseEntity.ok(Collections.singletonList(studentService.find(id)));
        }
        if (from != null || to != null) {
            return ResponseEntity.ok(studentService.findByAgeBetween(from, to));
        }
        return ResponseEntity.ok((List<Student>) studentService.getAll());
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public Student set(@RequestBody Student student) {
        return studentService.set(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> remove(@PathVariable Long id) {
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/numberOfAllStudents")
    public ResponseEntity<Long> numberOfAllStudents() {
        return ResponseEntity.ok(studentService.numberOfAllStudents());
    }

    @GetMapping("/averageAge")
    public ResponseEntity<Double> averageAge() {
        return ResponseEntity.ok(studentService.averageAge());
    }

    @GetMapping("/lastFiveStudent")
    public ResponseEntity<List<Student>> lastFiveStudent() {
        return ResponseEntity.ok(studentService.lastFiveStudent());
    }

    @GetMapping("/firstLetter/{letter}")
    public List<String> firstLetter(@PathVariable String letter) {
        return studentService.firstLetterA(letter);
    }

    @GetMapping("/avgAge")
    public Double avgAge() {
        return studentService.avgAge();
    }
    @GetMapping("/millions")
    public int millions() {
        return studentService.millions();
    }


    public Collection<Student> getAll() {
        return studentService.getAll();
    }
}
