package com.nordea.pmo.spring.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nordea.pmo.spring.dao.MasterDao;
import com.nordea.pmo.spring.entity.Nor_emp_details;
import com.nordea.pmo.spring.entity.Nor_inventory_details;
import com.nordea.pmo.spring.entity.Nor_onboarding_details;
import com.nordea.pmo.spring.entity.Nor_pmo_details;
import com.nordea.pmo.spring.entity.Nor_project_details;
import com.nordea.pmo.spring.entity.Nor_yubikey_details;
import com.nordea.pmo.spring.entity.Pmo_auth_details;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	MasterDao masterDao;
	

	@Override
	public List login(String loginForm) {
	
		
		Pmo_auth_details pmo_auth_details=new Pmo_auth_details();
		
		JSONObject jsonObject=null;
		try {
			jsonObject=new JSONObject(loginForm);
			
			pmo_auth_details.setAUTH_ID(jsonObject.getInt("username"));
			pmo_auth_details.setPASSWORD(jsonObject.getString("password"));
		}catch(Exception e){
			e.printStackTrace();
		}  
		
		
		
		return masterDao.login(pmo_auth_details.getAUTH_ID(),pmo_auth_details.getPASSWORD());

	}

	
	@Override
	public String saveEmployee(String empData) {
		
		Nor_emp_details employee=new Nor_emp_details();
		JSONObject jsonObj;
		
		
		try {
			jsonObj = new JSONObject(empData);
			//employee.setId(jsonObj.getInt("id"));
			employee.setPS_NO(jsonObj.getInt("psnumber"));
			employee.setFIRST_NAME(jsonObj.getString("firstname"));
			employee.setLAST_NAME(jsonObj.getString("lastname"));
			employee.setGENDER(jsonObj.getString("gender"));
			employee.setBASE_LOC(jsonObj.getString("city"));
			employee.setMAIL_ID(jsonObj.getString("email"));
			employee.setCONTACT_NO(jsonObj.getString("contactnumber"));
			employee.setQUAL_1(jsonObj.getString("qualification1"));
			employee.setDATE_OF_PASS_1(jsonObj.getString("dateofpassing1"));
			employee.setQUAL_2(jsonObj.getString("qualification2"));
			employee.setDATE_OF_PASS_2(jsonObj.getString("dateofpassing2"));
			employee.setQUAL_3(jsonObj.getString("qualification3"));
			employee.setDATE_OF_PASS_3(jsonObj.getString("dateofpassing3"));
			employee.setEXPERTIES(jsonObj.getString("expertise"));
			employee.setDATE_OF_EXP(jsonObj.getInt("experienceinmonths"));
			employee.setEXP_BFR_NOR(jsonObj.getInt("experiencebeforenordea"));
			employee.setEXP_BFR_LNT(jsonObj.getInt("experiencebeforelnt"));
			employee.setDOB(jsonObj.getString("birthdate"));
			employee.setPAN_NO(jsonObj.getString("pannumber"));
			employee.setPASSPORT_NO(jsonObj.getString("passportnumber"));
			employee.setPASSPORT_VAILD_FR(jsonObj.getString("passportfromdate"));
			employee.setPASSPORT_VAILD_TO(jsonObj.getString("passporttodate"));
			employee.setPROJECT_ID(jsonObj.getString("projectid"));
			employee.setNOR_ROLE(jsonObj.getString("designationcode"));
			employee.setSTART_DATE(jsonObj.getString("startdate"));
			employee.setEND_DATE(jsonObj.getString("enddate"));
			employee.setMAKER_ID(jsonObj.getInt("markerid"));
			employee.setSTATUS(jsonObj.getString("status"));	
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return masterDao.saveEmployee(employee);
	}
	
	public String updateEmployee(String employeeData, int id) {
		
		Nor_emp_details employee=new Nor_emp_details();
		JSONObject jsonObj;
		
		
		try {
			jsonObj = new JSONObject(employeeData);
			//employee.setId(jsonObj.getInt("id"));
		
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return masterDao.updateEmployee(employee, id);
		
		
	}

	@Override
	public String getParticularEmployee(String id) {
		return masterDao.getParticularEmployee(id);
	}

	@Override
	public String getListOfEmployee() {
		return masterDao.getListOfEmployee();
	}

	@Override
	public String deleteEmployee(int id) {
		return masterDao.deleteEmployee(id);
	}


	@Override
	public String saveOnboardEmployeeDetails(String onboardemployee,MultipartFile resumeFile,MultipartFile ndaFile) {
	
		Nor_onboarding_details employee=new Nor_onboarding_details();
		JSONObject jsonObj;
		try {
			jsonObj=new JSONObject(onboardemployee);
			employee.setONBOARD_ID(jsonObj.getInt("Onboardid"));
			employee.setPS_NO(jsonObj.getInt("psnumber"));
			employee.setPR_NO(jsonObj.getString("rrnumber"));
			employee.setOPP_ID(jsonObj.getString("opportunityid"));
			employee.setLATERAL_HIRE(jsonObj.getString("lateralhire"));
			employee.setTRANSFER_INIT(jsonObj.getString("transfer"));
			employee.setBUSS_UNIT(jsonObj.getString("businessunit"));
			employee.setCADRE(jsonObj.getString("cadre"));
			employee.setPROJECT_ID(jsonObj.getInt("projectid"));
			employee.setDEPT(jsonObj.getString("department"));
			employee.setBUSS_AREA_GRP(jsonObj.getString("businessarea"));
			employee.setBUSS_AREA_GRP(jsonObj.getString("businessgroup"));
			employee.setSITE(jsonObj.getString("site"));
			employee.setWORK_LOC_COUNTRY("worklocationcountry");
			employee.setWORK_LOC_CITY(jsonObj.getString("worklocationcity"));
			employee.setPRJ_COA_CONTRY(jsonObj.getString("projectcountry"));
			employee.setRM_PROFILE_REVD(jsonObj.getString("isprofilereceived"));
			employee.setCLIENT_PROFILE_SHRD(jsonObj.getString("isprofileshared"));
			employee.setCLIENT_INT_DATE(jsonObj.getString("clientinterviewdate"));
			employee.setCONF_DATE(jsonObj.getString("confirmeddate"));
			employee.setBILLED_STATUS(jsonObj.getString("isbilled"));
			employee.setBILL_START_DATE(jsonObj.getString("billingstartdate"));
			employee.setBILL_END_DATE(jsonObj.getString("billingenddate"));
			employee.setNIID_APP_ID(jsonObj.getString("applicationid"));
			employee.setG_LOGON_ID(jsonObj.getString("applicationid"));
			employee.setNOR_MGR(jsonObj.getString("nordeamanager"));
			employee.setNOR_COA(jsonObj.getString("nordeacontactpersonforcoa"));
			employee.setADD_REPLACE(jsonObj.getString("isadditionorreplacementofemployee"));
			employee.setREP_NAME(jsonObj.getString("whosereplacement"));
			employee.setREP_ASS_LST_DATE(jsonObj.getString("lastworkingday"));
			employee.setPM_NAME(jsonObj.getString("projectmanager"));
			employee.setDM_NAME(jsonObj.getString("deliverymanager"));
			employee.setLTI_JOIN_DATE(jsonObj.getString("ltijoiningdate"));
			employee.setNOR_JOIN_DATE(jsonObj.getString("nordeajoiningdate"));
			employee.setLTI_JOIN_DATE(jsonObj.getString("ltijoiningdate"));
			employee.setNDA_RCVD(jsonObj.getString("isndareceived"));
			//employee.setNDA_UPLOAD(jsonObj.getString("uploadedndaform"));
			employee.setRESUME_REVD(jsonObj.getString("isresumereceived"));
			//employee.setRESUME_UPLOAD(jsonObj.get("uploadedresumeform"));
			employee.setSTART_DATE(jsonObj.getString("startdate2"));
			employee.setEND_DATE(jsonObj.getString("enddate2"));
			employee.setMAKER_ID(jsonObj.getInt("makeridpsnumber"));
			employee.setSTATUS(jsonObj.getString("isactive"));
							
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		try {
			employee.setRESUME_UPLOAD(resumeFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		employee.setFILE_NAME(resumeFile.getOriginalFilename());
		try {
			employee.setNDA_UPLOAD(ndaFile.getBytes());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		employee.setFILE_NAME(resumeFile.getOriginalFilename());
		return masterDao.saveOnboardEmployeeDetails(employee);
	}


	@Override
	public String saveProjectDetails(String projectdetailsemp) {
		Nor_project_details employee=new 	Nor_project_details();
		JSONObject jsonObj;
		try{
			jsonObj=new JSONObject(projectdetailsemp);
			employee.setPROJECT_ID(jsonObj.getString("projectid"));
			employee.setPROJECT_NAME(jsonObj.getString("projectname"));
			employee.setPROJECT_TYPE(jsonObj.getString("projecttype"));
			employee.setSTART_DATE(jsonObj.getString("startdate"));
			employee.setEND_DATE(jsonObj.getString("enddate"));
			employee.setMAKER_ID(jsonObj.getInt("makerid"));
			employee.setSTATUS(jsonObj.getString("status"));			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return masterDao.saveProjectDetails(employee);
	}


	@Override
	public String savePmoDetails(String pmodetails) {
		Nor_pmo_details employee= new Nor_pmo_details();
		JSONObject jsonObj;
		try {
			jsonObj=new JSONObject(pmodetails);
			employee.setPMO_ID(jsonObj.getInt("pmoid"));
			employee.setPS_NO(jsonObj.getInt("psnumber"));
			employee.setPHYSICAL_ACCESS("physicalaccess");
			employee.setPHY_ACC_GRT_DT(jsonObj.getString("physicalaccessgranteddate"));
			employee.setPHY_ACC_RV_DT(jsonObj.getString("physicalaccessrevokeddate"));
			employee.setLOGICAL_ACCESS(jsonObj.getString("logicalaccess"));
			employee.setLG_ACC_GRT_DT(jsonObj.getString("logicalaccessgrantdatedate"));
			employee.setPHY_ACC_RV_DT(jsonObj.getString("logicalaccessrevdatedate"));
			employee.setBIOMETRIC_ACCESS(jsonObj.getString("biometricaccess"));
			employee.setBIO_ACC_GRT_DT(jsonObj.getString("biometricaccessgranteddate"));
			employee.setBIO_ACC_RV_DT(jsonObj.getString("biometricaccessrevokeddate"));
			employee.setNOR_IND(jsonObj.getString("norind"));
			employee.setNOR_IND_DATE(jsonObj.getString("norinddate"));
			employee.setNOR_IND_ATTEMPT(jsonObj.getInt("norindattempt"));
			employee.setCRIMINAL_BGV(jsonObj.getString("criminalbgv"));
			employee.setCRIMINAL_BGV_DT(jsonObj.getString("criminalbgvdate"));
			employee.setCRE_WR_BGV(jsonObj.getString("creditworth"));;
			employee.setCRE_WR_BGV_DT(jsonObj.getString("creditworthdate"));
			employee.setEMP_BGV(jsonObj.getString("empbgv"));
			employee.setEMP_BGV_DT(jsonObj.getString("empbgvdate"));
			employee.setEDU_BGV(jsonObj.getString("edubgv"));
			employee.setEDU_BGV_DT(jsonObj.getString("edubgvdate"));
			employee.setSTART_DATE(jsonObj.getString("startdate"));
			employee.setEND_DATE(jsonObj.getString("enddate"));
			employee.setMAKER_ID(jsonObj.getInt("makerid"));
			employee.setSTATUS(jsonObj.getString("status"));
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return masterDao.savePmoDetails(employee);
	}


	@Override
	public String saveYubikeyDetails(String yubikeydetails) {
		Nor_yubikey_details employee=new 	Nor_yubikey_details();
		JSONObject jsonObj;
		try{
			jsonObj=new JSONObject(yubikeydetails);
			employee.setYUBIKEY_NO(jsonObj.getInt("yubikeyno"));
			employee.setYUBIKEY_ASSIGN_DATE(jsonObj.getString("yubikeyassigndate"));
			employee.setYUBIKEY_RELEASE_DATE(jsonObj.getString("yubikeyreleasedate"));
			employee.setPS_NO(jsonObj.getInt("psnumber"));
			employee.setKID(jsonObj.getString("kid"));
			employee.setSTART_DATE(jsonObj.getString("startdate"));
			employee.setEND_DATE(jsonObj.getString("enddate"));
			employee.setMAKER_ID(jsonObj.getInt("makerid"));
			employee.setSTART_DATE(jsonObj.getString("status"));						
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return masterDao.saveYubikeyDetails(employee);
	}


	@Override
	public String saveInventoryDetails(String inventorydetails) {
		Nor_inventory_details employee=new Nor_inventory_details();
		JSONObject jsonObj;
		try {
			jsonObj=new JSONObject(inventorydetails);
			employee.setINV_ID(jsonObj.getInt("invid"));
			employee.setPS_NO(jsonObj.getInt("psnumber"));
			employee.setKID(jsonObj.getString("kid"));
			employee.setYUBIKEY_NO(jsonObj.getInt("yubikeyno"));
			employee.setSEAT_NO(jsonObj.getString("seatno"));
			employee.setMONITOR_IV_NO_1(jsonObj.getString("monitorno"));
			employee.setMONITOR_SERIAL_NO_1(jsonObj.getString("monitorserialno1"));
			employee.setMONITOR_IV_NO_2(jsonObj.getString("monitorivno"));
			employee.setMONITOR_SERIAL_NO_2(jsonObj.getString("monitorserialno2"));
			employee.setCPU_IV_NO(jsonObj.getString("cpuivno"));
			employee.setCPU_SERIAL_NO(jsonObj.getString("cpuserialno"));
			employee.setHEADPHONE(jsonObj.getString("headphone"));
			employee.setDRAWER_KEY(jsonObj.getString("drawerkey"));
			employee.setSTART_DATE(jsonObj.getString("startdate"));
			employee.setEND_DATE(jsonObj.getString("enddate"));
			employee.setMAKER_ID(jsonObj.getInt("makerid"));
			employee.setSTATUS(jsonObj.getString("status"));
			
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return masterDao.saveInventoryDetails(employee);
	}

}
