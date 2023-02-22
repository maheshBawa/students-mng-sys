package com.student.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class StudentService {
    @GetMapping
	public List<Student> getStudents(){
		return List.of(
			new Student(
				1L,
				"Mahesh",
				LocalDate.of(1998, Month.MAY, 31),
				21,
				"maheshbawantha1998@gmail.com"
			)
		);
	}
}
