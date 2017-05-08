/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.jpaDemo3.controller;

import bd.ac.seu.jpaDemo3.model.Student;
import bd.ac.seu.jpaDemo3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author shithilboss
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam String studentId,
            @RequestParam String studentName,
            @RequestParam double cgpa) {
        Student student = new Student(studentId, studentName, cgpa);
        System.out.println(student);
        studentRepository.save(student);

        return "geting";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Student> listStudents() {
        Iterable<Student> studentsList = studentRepository.findAll();
        for (Student student : studentsList) {
            System.out.println(student);
        }
        return studentsList;
    }

}
