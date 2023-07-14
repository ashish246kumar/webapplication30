package com.nagarro.springApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.springApplication.dao.studentDao;
import com.nagarro.springApplication.entity.Student;

@Service
public class StudentService {
    
	@Autowired
	private studentDao studentdao;
	
	public Student createStudent(Student student) {
		return studentdao.save(student);
	}
	public List<Student>getStudent(){
		return studentdao.findAll();
	}
	public Student getStudent(String email) {
		Student user = studentdao.findByEmail(email);
		if(user==null) {
			return null;
		}
		return user;
	}
}
