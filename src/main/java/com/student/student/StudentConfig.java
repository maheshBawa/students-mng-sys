package com.student.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mahesh = new Student(
                    1L,
                    "Lahiru",
                    LocalDate.of(1998, Month.MAY, 31),
                    "maheshbawantha1998@gmail.com");

            Student bawantha = new Student(
                    2L,
                    "Bawantha",
                    LocalDate.of(1997, Month.MAY, 21),
                    "bawantha1998@gmail.com");

            repository.saveAll(List.of(mahesh, bawantha));
        };
    }
}
