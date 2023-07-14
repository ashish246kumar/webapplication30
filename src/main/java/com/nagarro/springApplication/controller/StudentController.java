package com.nagarro.springApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.nagarro.springApplication.entity.Student;
import com.nagarro.springApplication.service.StudentService;


@CrossOrigin(origins="*")
@RestController
public class StudentController {
    
	@Autowired
	private StudentService studentservice;
	@PostMapping("/addStudent")
	public ResponseEntity<Student> createstudent(@RequestBody Student student) {
		 
		try {
			Student createdStudent = studentservice.createStudent(student);
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	    	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	       }
		
	}
	@GetMapping("/student")
	public ResponseEntity<List<Student>>getStudents(){
		   List<Student> student= studentservice.getStudent();
		   if(student==null) {
			   return ResponseEntity.ok(null);
		   }
		   
		   return ResponseEntity.ok(student);
	}
	@GetMapping("/student/{email}")
	public ResponseEntity<Student>getStudent(@PathVariable("email")String email){
		   Student student= studentservice.getStudent(email);
		   if(student==null) {
			   return ResponseEntity.ok(null);
		   }
		   
		   return ResponseEntity.ok(student);
	}
	
	

}
