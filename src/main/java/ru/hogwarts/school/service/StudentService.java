package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        logger.info("Был вызван метод add");
        return studentRepository.save(student);
    }

    public Student find(long id) {
        logger.info("Был вызван метод find");
        return studentRepository.findById(id).get();
    }

    public Student set(Student student) {
        logger.info("Был вызван метод set");
        return studentRepository.save(student);
    }

    public void remove(long id) {
        logger.info("Был вызван метод remove");
        studentRepository.deleteById(id);
    }

    public  Collection<Student> getAll() {
        logger.info("Был вызван метод getAll");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(Integer age) {
        logger.info("Был вызван метод findByAge");
        return studentRepository.findByAge(age);
    }

    public List<Student> findByAgeBetween(Integer from, Integer to) {
        logger.info("Был вызван метод findByAgeBetween");
        return studentRepository.findByAgeBetween(from, to);
    }

    public Long numberOfAllStudents() {
        logger.info("Был вызван метод numberOfAllStudents");
        return studentRepository.numberOfAllStudents();
    }
    public double averageAge () {
        logger.info("Был вызван метод averageAge");
        return studentRepository.averageAge();
    }

    public List<Student> lastFiveStudent() {
        logger.info("Был вызван метод lastFiveStudent");
        return studentRepository.lastFiveStudent();
    }
}
