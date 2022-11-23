package com.example.University.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Model.Department;

@Repository
public interface DepermentRepo extends JpaRepository<Department,Integer>{
	
}
