package com.student.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.transaction.Transactional;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
    @GetMapping
	public List<Student>getStudents(){
		return studentRepository.findAll();
	}

	public Student addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()){
			throw new IllegalStateException("email taken");
		}
		return studentRepository.save(student);
    }

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);

		if (!exists){
			throw new IllegalStateException(
				"Student with id " + studentId + "does not exists"
			);
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
    public  void updateStudent(Long studentId, String name, String email, LocalDate dob) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
			"student with id " + studentId + " does not exist " )
			);

			if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
				student.setName(name);
			}

			if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
				Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

				if(studentOptional.isPresent()){
					throw new IllegalStateException("Email was taken");
				}
				student.setEmail(email);
			}

			if(dob != null && !Objects.equals(student.getDob(), dob)){
				student.setDob(dob);
			}
    }
}
