package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Collection<Student> getAll() {
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

    public double averageAge() {
        logger.info("Был вызван метод averageAge");
        return studentRepository.averageAge();
    }

    public List<Student> lastFiveStudent() {
        logger.info("Был вызван метод lastFiveStudent");
        return studentRepository.lastFiveStudent();
    }

    public List<String> firstLetterA(String letter) {
        letter = letter.toUpperCase();
        String finalLetter = letter;
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(name -> name.startsWith(finalLetter))
                .sorted()
                .collect(Collectors.toList());
    }

    public double avgAge() {
        return studentRepository.findAll().stream()
                .mapToDouble(i -> (double) i.getAge())
                .average()
                .orElseThrow(() -> new RuntimeException("ошибка среднего возраста"));
    }

    public int millions() {
        long start = System.currentTimeMillis();
        int result = Stream
                .iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        long finish = System.currentTimeMillis();
        logger.info("start-stop "+(finish-start));
        return result;
    }
}
