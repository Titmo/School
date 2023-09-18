package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(Integer age);

    List<Student> findByAgeBetween(Integer form, Integer to);

    @Query(value = "SELECT COUNT(*) FROM \"public\".student",nativeQuery = true)
    Long numberOfAllStudents();
    @Query(value = "SELECT AVG(age) FROM \"public\".student",nativeQuery = true)
    Long averageAge();
    @Query(value = "SELECT * FROM \"public\".student ORDER BY \"public\".student.\"id\" DESC LIMIT 5",nativeQuery = true)
    List<Student> lastFiveStudent();
}
