package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.dto.StudentDto;
import com.neosoft.model.Student;
import com.neosoft.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/save")
	public ResponseEntity<?> createUser(@RequestBody StudentDto dto) {
		Student student = studentService.save(dto);
		
		return new ResponseEntity<Student>(student,HttpStatus.CREATED) ;
	}

	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll() {
		List<Student> list = studentService.finallAll();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public List<Student> userController(@PathVariable("id") Integer id) {
		return studentService.getuser(id);
	}
	
}
