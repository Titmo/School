package ru.hogwarts.school.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public Student find(long id) {
        return studentRepository.findById(id).get();
    }

    public Student set(Student student) {
        return studentRepository.save(student);
    }

    public void remove(long id) {
        studentRepository.deleteById(id);
    }

    public  Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(Integer age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> findByAgeBetween(Integer from, Integer to) {
        return studentRepository.findByAgeBetween(from, to);
    }

    public Long numberOfAllStudents() {
        return studentRepository.numberOfAllStudents();
    }
    public double averageAge () {
        return studentRepository.averageAge();
    }

    public List<Student> lastFiveStudent() {
        return studentRepository.lastFiveStudent();
    }
}
