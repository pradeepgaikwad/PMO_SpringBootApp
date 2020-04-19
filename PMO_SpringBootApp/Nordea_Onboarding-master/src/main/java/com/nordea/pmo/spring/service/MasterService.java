package com.nordea.pmo.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface MasterService {
	
	//------------EMployee---------------------------------
	
	public List login(String loginForm);
	
	public String saveEmployee(String employee);
	
	public String saveOnboardEmployeeDetails(String onboardemployee,MultipartFile resumeFile,MultipartFile ndaFile);
	
	public String saveProjectDetails(String Nor_project_details);
	
	public String savePmoDetails(String Nor_pmo_details);
	
	public String saveYubikeyDetails(String Nor_yubikey_details);
	
	public String getParticularEmployee(String id);
	
	public String getListOfEmployee(); 
	
	public String updateEmployee( String employee, int id);
	
	public String deleteEmployee(int id);

	public String saveInventoryDetails(String inventorydetails);

}
