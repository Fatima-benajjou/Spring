package org.example.spring_exercice_etudiant.Service;

import org.example.spring_exercice_etudiant.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students;
    private int compteurId = 1;

    public StudentService() {
        students = new ArrayList<>();

        students.add((new Student(compteurId++, "Ben", "Fat", 18, "fafafa")));
        students.add((new Student(compteurId++, "Bena", "Fati", 20, "fatiti")));
        students.add((new Student(compteurId++, "Benajjou", "Fatima", 35, "famama")));

    }

    public void addStudent(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public Student getStudentByLastName(String lastName) {
        return students.stream().filter(s -> s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public boolean deleteStudentById(int id) {
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        return students.remove(student);
    }

    public Student updateStudent(Student student) {
        Student studentUpDate = getStudentById(student.getId());
        int index = students.indexOf(studentUpDate);
        return students.set(index, student);
    }

}

