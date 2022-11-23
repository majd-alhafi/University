package com.example.University.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Model.Course;
import com.example.University.Service.CourseServices;

@RestController
public class CourseController {
	@Autowired
	CourseServices courseServices;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseServices.getAllCourses();
	}
	
	@GetMapping("/department/{id}/courses")
	@ResponseBody
	public List<Course> getEmployeesById(@PathVariable Integer id) {
	    return courseServices.getCoursesByDeparmentId(id);
	}
}
