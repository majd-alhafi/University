package com.example.University.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{
	public Student findByEmail(String Email);
}
