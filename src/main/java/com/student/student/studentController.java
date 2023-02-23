package com.student.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class studentController {

    private final StudentService studentService;

    @Autowired
    public studentController(StudentService studentService){
        this.studentService = studentService;
    }

    // post request
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    // get request
    @GetMapping
	public List<Student> getStudents(){
        return studentService.getStudents();
	}
}