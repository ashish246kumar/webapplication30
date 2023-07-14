package com.nagarro.springApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nagarro.springApplication.entity.Student;


@Repository
public interface studentDao extends JpaRepository<Student,String>{
	Student findByEmail(String email);
}
