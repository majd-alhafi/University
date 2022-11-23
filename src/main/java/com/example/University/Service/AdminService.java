package com.example.University.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Model.Admin;
import com.example.University.Repository.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;
	
	private List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}
	
	private boolean checkCredentials(Admin admin, List<Admin> admins,Integer departmentId) {
		String adminEmail = admin.getEmail();
		String adminPassword = admin.getPassword();
		for(int i=0;i<admins.size();i++) {
			Admin tempAdmin = (Admin) admins.get(i);
			String tempEmail = tempAdmin.getEmail();
			String tempPassword = tempAdmin.getPassword();
			Integer tempDepartmentId =  tempAdmin.getDepartment().getId();
			if (tempEmail.equals(adminEmail) && tempPassword.equals(adminPassword) && tempDepartmentId == departmentId )
				return true;
		}
		return false;
	}

	public String adminLogging(Admin admin, Integer departmentId) {
		if(checkCredentials(admin,getAllAdmins(),departmentId)) 
			return "Hello ";
		return "Credentials are not corrected try again..";
	}

	
}
