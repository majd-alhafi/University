package com.example.University.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.University.Model.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{
	
}
