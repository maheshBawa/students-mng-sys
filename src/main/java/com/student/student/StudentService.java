package com.student.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
    @GetMapping
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public Student addNewStudent(Student student) {
		System.out.println(student);
		return studentRepository.save(student);
    }
}