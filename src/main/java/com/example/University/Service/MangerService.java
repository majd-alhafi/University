package com.example.University.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Model.Admin;
import com.example.University.Model.Manger;
import com.example.University.Repository.AdminRepo;
import com.example.University.Repository.MangerRepo;

@Service
public class MangerService {
	@Autowired 
	AdminRepo adminRepo;
	
	@Autowired 
	MangerRepo mangerRepo;
	public void addAdmin(Admin admin) {
		adminRepo.save(admin);
	}
	
	public void deleteAdmin(Integer id) {
		adminRepo.deleteById(id);
	}

	public boolean login(Manger manger) {
		if (manger.getEmail().equals("manger") && manger.getPassword().equals("123"))
			return true;
		return false;
	}
	
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	public void updateAdmin(Integer id, Admin newAdmin) {
		Admin tempAdmin = adminRepo.findById(id).get();
		if (tempAdmin != null) {
			tempAdmin.setDepartment(newAdmin.getDepartment());
			tempAdmin.setName(newAdmin.getName());
			addAdmin(tempAdmin);
		}
		
	}
}
