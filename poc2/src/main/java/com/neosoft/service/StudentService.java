package com.neosoft.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.dto.StudentDto;
import com.neosoft.model.Project;
import com.neosoft.model.Student;
import com.neosoft.repo.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

	@Autowired
	private StudentRepository repo;
	public Student save(StudentDto dto) {
		Student student=new Student();
		
		
		
		student.setFirstName(dto.getFirstName());
		student.setLastName(dto.getLastName());
		student.setEmailAddress(dto.getEmailAddress());
		student.setMobileNumber(dto.getMobileNumber());
		
		Set<Project> set =new HashSet<>();
		Project p=new Project();
		p.setProjectName(dto.getProject().getProjectName());
		p.setDuration(dto.getProject().getDuration());
		set.add(p);
		student.setProjects(set);
		student=	repo.save(student);
		return student;
	}
	public List<Student> finallAll() {
		return repo.findAll();
	}
	public List<Student> getuser(Integer id) {
		
		return repo.findAll().stream().filter(s -> s.getId().equals(id)).collect(Collectors.toList());
	}

}
