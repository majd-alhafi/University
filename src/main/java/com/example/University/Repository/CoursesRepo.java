package com.example.University.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.University.Model.Course;

@Repository
public interface CoursesRepo extends JpaRepository<Course,Integer>{
	public List<Course> findByDepartmentId(Integer id);
	//public List<Course> findByRegistrationsByStudentById(Integer id);
}
