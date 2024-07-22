package org.example.spring_exercice_etudiant.Controller;

import org.example.spring_exercice_etudiant.Model.Student;
import org.example.spring_exercice_etudiant.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String accueil() {
        return "accueil";
    }


    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/detail/{studentId}")
    public String detailStudent(@PathVariable("studentId") int studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/search")
    public String showStudent(Model model) {
        return "search";
    }

    @PostMapping("/search")
    public String searchStudent(@RequestParam("lastname") String lastName, Model model) {
        List<Student> students = new ArrayList<>();
        students.add(studentService.getStudentByLastName(lastName));
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/inscription")
    public String addStudent(@RequestParam(value = "studentId", required = false) Integer id, Model model) {
        if(id != null) {
        Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
        } else {
            model.addAttribute("student", new Student());
        }
        return "inscription";

    }


    @PostMapping("/inscription")
    public String submitForm(@ModelAttribute("student") Student student, Model model) {

        if (student.getId() > 0) {
            studentService.updateStudent(student);
        } else {
            studentService.addStudent(student);
        }
        return "redirect:/list";
    }


    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId, Model model) {
        if (studentService.deleteStudentById(studentId)) {
            return "redirect:/list";
        }
        return "/accueil";
    }


}