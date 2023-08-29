package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Service
public class FacultyService {
    private final HashMap <Long, Faculty> staffFaculty = new HashMap<>();


    private long idLast = 0;

    public Faculty add(Faculty faculty) {
        faculty.setId(++idLast);
        staffFaculty.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty find(long id) {
        return staffFaculty.get(id);
    }
    public Faculty set (Faculty faculty) {
        if (!staffFaculty.containsKey(faculty.getId())) {
            return null;
        }
        staffFaculty.put(faculty.getId(), faculty);
        return faculty;
    }
    public Faculty remove (long id) {
        return staffFaculty.remove(id);
    }
    public HashMap<Long,Faculty> getAll () {
        return staffFaculty;
    }
    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : staffFaculty.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
