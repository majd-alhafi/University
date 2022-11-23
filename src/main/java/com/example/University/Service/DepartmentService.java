package com.example.University.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Model.Department;
import com.example.University.Repository.DepermentRepo;

@Service
public class DepartmentService {
	@Autowired
	DepermentRepo departmentRepo;
	
	public List<Department> getAllDepartments(){
		return departmentRepo.findAll();
	}
	
	public void updateDepartment(Integer id, Department newDepartment) {
		Department tempDepartment = getDeparment(id).get();
		if (tempDepartment != null) {
			tempDepartment.setName(newDepartment.getName());
			addDepartment(tempDepartment);
		}	
	}
	
	public Optional<Department> getDeparment(Integer id) {
		return departmentRepo.findById(id);
	}
	
	public void deleteDepartment(Integer id) {
		departmentRepo.deleteById(id);
	}

	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}
}
