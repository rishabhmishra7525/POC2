package com.neosoft.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
