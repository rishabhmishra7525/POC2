package com.neosoft.dto;

import lombok.Data;

@Data
public class StudentDto {

	private String firstName;
	private String lastName;
	private Integer mobileNumber;
	private String emailAddress;
	 private Project project;	
}
