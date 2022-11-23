package com.example.University.Controller;

import java.util.List;
//import java.util.Set;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.University.Model.Student;
import com.example.University.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired 
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/add-student")
	public void addStudent(@RequestBody Student newStudent) {
		studentService.addStudent(newStudent);
	}
	
	@PostMapping("/student-login")
	public String studentLogging(@RequestBody Student student, HttpServletResponse response,HttpServletRequest request) {
		if(!studentService.checkIfStudentLoggedIn(request))
			return studentService.studentLogging(student, response);
		return "You are logged in";
	}
	
	@GetMapping("/student/{id}/courses")
	public Set<String> getStudentCoursesName(@PathVariable Long id) {
		return studentService.getStudentCoursesName(id);
	}
	
	@PostMapping("/student/{id}/enroll-in-course")
	public void enrollInCourse(@RequestBody List<Integer> coursesId,@PathVariable Long id) {
		studentService.enrollInCourse(coursesId,id);
	}
}
