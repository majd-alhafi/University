package com.example.University.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Model.Admin;
import com.example.University.Model.Department;
import com.example.University.Model.Manger;
import com.example.University.Service.DepartmentService;
import com.example.University.Service.MangerService;

@RestController
public class MangerController {
	@Autowired 
	MangerService mangerService;
	
	@Autowired 
	DepartmentService departmentService;
	
	@PostMapping("/manager-login")
	public String mangerLoggin(@RequestBody Manger manger) {
		if(mangerService.login(manger))
			return "Welcome Manager";
		return "Credentials are not corrected..";
	}
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins(){
		return mangerService.getAllAdmins();
	}
	
	@PostMapping("/add-admin")
	public void addAdmin(@RequestBody Admin admin) {
		mangerService.addAdmin(admin);
	}
	
	@PutMapping("/admin/{id}")
	public void updateAdmin(@PathVariable Integer id,@RequestBody Admin newAdmin) {
			mangerService.updateAdmin(id,newAdmin);
	}
	
	@DeleteMapping("/delete-admin/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		mangerService.deleteAdmin(id);
	}
	
	@PostMapping("/add-department")
	public void addNewDepatment(@RequestBody Department newDepartment) {
		departmentService.addDepartment(newDepartment);
	}
	
	@PutMapping("/department/{id}")
	public void updateDepartment(@PathVariable Integer id,@RequestBody Department newDepartment) {	
		departmentService.updateDepartment(id,newDepartment);
	}
	
	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable Integer id) {
		departmentService.deleteDepartment(id);
	}
}
