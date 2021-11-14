package com.neosoft.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author @Rishabh
 *
 */


@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name="student_details")
public class Student {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer mobileNumber;
	private String emailAddress;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(	name="student_project",
				joinColumns	 =		@JoinColumn(name = "student_id"),
				inverseJoinColumns =  @JoinColumn (name= "project_id")
	)
	
	private Set<Project> projects;

	public Student(String firstName, String lastName, String emailAddress, Integer mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		
	}

	
}
