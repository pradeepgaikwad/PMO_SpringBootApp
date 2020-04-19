package com.nordea.pmo.spring.dao;

import java.util.List;

import com.nordea.pmo.spring.entity.Nor_emp_details;
import com.nordea.pmo.spring.entity.Nor_inventory_details;
import com.nordea.pmo.spring.entity.Nor_onboarding_details;
import com.nordea.pmo.spring.entity.Nor_pmo_details;
import com.nordea.pmo.spring.entity.Nor_project_details;
import com.nordea.pmo.spring.entity.Nor_yubikey_details;

public interface MasterDao {
	
	//------------EMployee---------------------------------
	
	public List login(int username, String password);
	
	public String saveEmployee(Nor_emp_details employee);
	
	public String getParticularEmployee(String id);
	
	public String getListOfEmployee(); 
	
	public String updateEmployee(Nor_emp_details employee, int id);
	
	public String deleteEmployee(int id);

	public String saveOnboardEmployeeDetails(Nor_onboarding_details employee);

	public String saveProjectDetails(Nor_project_details employee);

	public String savePmoDetails(Nor_pmo_details employee);

	public String saveYubikeyDetails(Nor_yubikey_details employee);

	public String saveInventoryDetails(Nor_inventory_details employee);
	
	//---------------------next ---------------------------
	
}
