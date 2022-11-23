package com.example.University.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Model.Admin;
import com.example.University.Model.Course;
import com.example.University.Service.AdminService;
import com.example.University.Service.CourseServices;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired 
	CourseServices courseService;
	
	@PostMapping("/admin-login/{departmentId}")
	public String adminLogging(@RequestBody Admin admin ,@PathVariable Integer departmentId) {
		return adminService.adminLogging(admin,departmentId);
	}
	
	@PostMapping("/add-course")
	public void addNewDepatment(@RequestBody Course newCourse) {
		courseService.addCourse(newCourse);
	}
	
	@PutMapping("/course/{id}")
	public void updateCourse(@PathVariable Integer id,@RequestBody Course newCourse) {
		courseService.updateCourse(id,newCourse);
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseService.deleteCourse(id);
	}
}
