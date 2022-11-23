package com.example.University.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Model.Department;
import com.example.University.Service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService deparmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDeparments() {
		return deparmentService.getAllDepartments();
	}
		
	@GetMapping("/department/{id}")
	@ResponseBody
	public Optional<Department> getEmployeesById(@PathVariable Integer id) {
	    return deparmentService.getDeparment(id);
	}
}
