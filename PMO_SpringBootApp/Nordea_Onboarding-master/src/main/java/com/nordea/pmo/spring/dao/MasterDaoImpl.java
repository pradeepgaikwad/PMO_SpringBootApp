package com.nordea.pmo.spring.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nordea.pmo.spring.entity.Nor_emp_details;
import com.nordea.pmo.spring.entity.Nor_inventory_details;
import com.nordea.pmo.spring.entity.Nor_onboarding_details;
import com.nordea.pmo.spring.entity.Nor_pmo_details;
import com.nordea.pmo.spring.entity.Nor_project_details;
import com.nordea.pmo.spring.entity.Nor_yubikey_details;
import com.nordea.pmo.spring.entity.Pmo_auth_details;
@Repository
public class MasterDaoImpl implements MasterDao
{
   
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//----create -------------
	
    @Override
	public List login(int username, String password) {

		List<Map<String, Object>> list = null;

		String loginQuery = "select AUTH_ID,USER_ID,AUTH_ROLE,PASSWORD,STATUS from pmo_auth_details where auth_id=? and password=?";
		try {
			list = jdbcTemplate.queryForList(loginQuery, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(list.isEmpty()){
			return null;
		}
		else {
			//pmo_auth_details.setAUTH_ID(list.get());
			return list;	
		}
	}
	
	//create user
	
	@Override
	public String saveEmployee(Nor_emp_details emp){
		int empcount=0;
    String queryToInsertEmp=
    		"INSERT INTO  `pmo`.`nor_emp_details`(`PS_NO`,`FIRST_NAME`,`LAST_NAME`,`GENDER`,`BASE_LOC`,`MAIL_ID`,`CONTACT_NO`,\r\n" + 
    		"`QUAL_1`,`DATE_OF_PASS_1`,`QUAL_2`,`DATE_OF_PASS_2`,`QUAL_3`,`DATE_OF_PASS_3`,`EXPERTIES`,\r\n" + 
    		"`DATE_OF_EXP`,`EXP_BFR_NOR`,`EXP_BFR_LNT`,`DOB`,`PAN_NO`,`PASSPORT_NO`,`PASSPORT_VAILD_FR`,`PASSPORT_VAILD_TO`,\r\n" + 
    		"`PROJECT_ID`,`NOR_ROLE`,`START_DATE`,`END_DATE`,`MAKER_ID`,`STATUS`)\r\n" + 
    		"VALUES(\r\n" + 
    		"?,?,?,?,?,?,?\r\n" + 
    		",?,?,?,?,?,?,?\r\n" + 
    		",?,?,?,?,?,?,?\r\n" + 
    		",?,?,?,?,?,?,?)";
      
		
		try {
			 empcount=jdbcTemplate.update(queryToInsertEmp,new Object[]
					 
			{
			emp.getPS_NO(),emp.getFIRST_NAME(),emp.getLAST_NAME(),emp.getGENDER(),emp.getBASE_LOC(),emp.getMAIL_ID(),emp.getCONTACT_NO(),
			emp.getQUAL_1(),emp.getDATE_OF_PASS_1(),emp.getQUAL_2(),emp.getDATE_OF_PASS_2(),emp.getQUAL_3(),emp.getDATE_OF_PASS_3(),emp.getEXPERTIES(),
			emp.getDATE_OF_EXP(),emp.getEXP_BFR_NOR(),emp.getEXP_BFR_LNT(),emp.getDOB(),emp.getPAN_NO(),emp.getPASSPORT_NO(),emp.getPASSPORT_VAILD_FR(),emp.getPASSPORT_VAILD_TO(),
			emp.getPROJECT_ID(),emp.getNOR_ROLE(),emp.getSTART_DATE(),emp.getEND_DATE(),emp.getMAKER_ID(),emp.getSTATUS()
			});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"Employee Not Created\"}";
		   }
	
		   return "{\"status\": \"Success\",\"reason\": \"Employee Created Successfully\"}";
	   }

	//--------------get Employee-----------
	
	@Override
	public String getListOfEmployee() {
		List<Map<String, Object>> allUserList = null;

		String queryToGetAllUser=" select * from user ";



		allUserList = jdbcTemplate.queryForList(queryToGetAllUser);

		JSONObject json = new JSONObject();

		if(allUserList.size() >= 0) {

			try {
				json.put("UsersList", allUserList);
			} catch (JSONException e) { 
				e.printStackTrace();
			}
		}

		return json.toString();

	}
	
	@Override 
	public String getParticularEmployee(String id) {

		String query =" select * from nor_emp_details where PS_NO=?";

		List<Map<String, Object>> empList = jdbcTemplate.queryForList(query,id);
		JSONObject json = new JSONObject();

		if(empList.size() >= 0) {
			try {
				json.put("empList", empList);

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		return json.toString();
	}
	
	@Override
	@Transactional(rollbackFor={RuntimeException.class,Exception.class})
	public String updateEmployee(Nor_emp_details employee, int id) {
	
	int updateCount=0;
	try {
	
	String updateUserQuery= "update user set name = ? , email = ? , mobileNumber = ? , username = ? , password = ? where id = ?";
	//updateCount = jdbcTemplate.update(updateUserQuery, new Object[]{user.getName(),user.getEmail(),user.getMobileNumber(),user.getUsername(),user.getPassword(),id});
	
	}catch (Exception e) {
	e.printStackTrace();
	}
	
	return "{\"status\": \"Success\",\"reason\": \"Ok\"}";
	}
 
	@Override
	public String deleteEmployee(int id) {
	int deleteCount=0;
	String queryToDeleteUser= "delete from nor_emp_details where PS_NO=?";
	try{
	deleteCount = jdbcTemplate.update(queryToDeleteUser,id);
	}catch (Exception e) 
	{
	e.printStackTrace();
	if(deleteCount==0)
	{
	
	return "unable to delete Employee ";
	}
	}
	
	return "{\"status\": \"Success\",\"reason\": \"Ok\"}";
	}

	@Override
	public String saveOnboardEmployeeDetails(Nor_onboarding_details emp) {
		int empcount=0;
		String queryToInsertOnboardDetails="INSERT INTO `pmo`.`nor_onboarding_details`\r\n" + 
				"(`ONBOARD_ID`,`PS_NO`,`PR_NO`,`OPP_ID`,`LATERAL_HIRE`,`TRANSFER_INIT`,`BUSS_UNIT`,\r\n" + 
				"`CADRE`,`PROJECT_ID`,`DEPT`,`BUSS_AREA`,`BUSS_AREA_GRP`,`SITE`,`WORK_LOC_COUNTRY`,\r\n" + 
				"`WORK_LOC_CITY`,`PRJ_COA_CONTRY`,`RM_PROFILE_REVD`,`CLIENT_PROFILE_SHRD`,`CLIENT_INT_DATE`,`CONF_DATE`,`BILLED_STATUS`,\r\n" + 
				"`BILL_START_DATE`,`BILL_END_DATE`,`NIID_APP_ID`,`G_LOGON_ID`,`NOR_MGR`,`NOR_COA`,`ADD_REPLACE`,\r\n" + 
				"`REP_NAME`,`REP_ASS_LST_DATE`,`PM_NAME`,`DM_NAME`,`LTI_JOIN_DATE`,`NOR_JOIN_DATE`,`NDA_RCVD`,\r\n" + 
				"`NDA_UPLOAD`,`RESUME_REVD`,`RESUME_UPLOAD`,`START_DATE`,`END_DATE`,`MAKER_ID`,`STATUS`)\r\n" + 
				"VALUES\r\n" + 
				"(?,?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,?,?)";
		try {
			 empcount=jdbcTemplate.update(queryToInsertOnboardDetails,new Object[]		 
			{
					emp.getONBOARD_ID(),emp.getPS_NO(),emp.getOPP_ID(),emp.getLATERAL_HIRE(),emp.getTRANSFER_INIT(),emp.getBUSS_UNIT(),
					emp.getCADRE(),emp.getPROJECT_ID(),emp.getDEPT(),emp.getBUSS_AREA(),emp.getBUSS_AREA_GRP(),emp.getSITE(),emp.getWORK_LOC_COUNTRY(),
					emp.getWORK_LOC_CITY(),emp.getPRJ_COA_CONTRY(),emp.getRM_PROFILE_REVD(),emp.getCLIENT_PROFILE_SHRD(),emp.getCLIENT_INT_DATE(),emp.getCONF_DATE(),emp.getBILLED_STATUS(),
					emp.getBILL_START_DATE(),emp.getBILL_END_DATE(),emp.getNIID_APP_ID(),emp.getG_LOGON_ID(),emp.getNOR_MGR(),emp.getNOR_COA(),emp.getADD_REPLACE(),
					emp.getREP_NAME(),emp.getREP_ASS_LST_DATE(),emp.getPM_NAME(),emp.getDM_NAME(),emp.getLTI_JOIN_DATE(),emp.getNOR_JOIN_DATE(),emp.getNDA_RCVD(),
					emp.getNDA_UPLOAD(),emp.getRESUME_REVD(),emp.getRESUME_UPLOAD(),emp.getSTART_DATE(),emp.getEND_DATE(),emp.getMAKER_ID(),emp.getSTATUS()
					
				});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"Employee Not Created\"}";
		   }
	
		   return "{\"status\": \"Success\",\"reason\": \"Onboarding Details Inserted Successfully\"}";
	}

	@Override
	public String saveProjectDetails(Nor_project_details emp) {
		int empcount=0;
	    String queryToInsertProjectDetails="INSERT INTO `pmo`.`nor_project_details`\r\n" + 
	    		"(`PROJECT_ID`,`PROJECT_TYPE`,`PROJECT_NAME`,`START_DATE`,\r\n" + 
	    		"`END_DATE`,`MAKER_ID`,`STATUS`)\r\n" + 
	    		"VALUES(\r\n" + 
	    		"?,?,?,?,\r\n" + 
	    		"?,?,?)";
		try {
			 empcount=jdbcTemplate.update(queryToInsertProjectDetails,new Object[]
					 
			{
					emp.getPROJECT_ID(),emp.getPROJECT_TYPE(),emp.getPROJECT_NAME(),emp.getSTART_DATE(),
					emp.getEND_DATE(),emp.getMAKER_ID(),emp.getSTATUS()
				});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"Employee Not Created\"}";
		   }
	
		   return "{\"status\": \"Success\",\"reason\": \"Project Details Inserted Successfully\"}";
	}

	@Override
	public String savePmoDetails(Nor_pmo_details emp) {
		int empcount=0;
	    String queryToInsertPmoDetails="INSERT INTO `pmo`.`nor_pmo_details`\r\n" + 
	    		"(`PMO_ID`,`PS_NO`,`PHYSICAL_ACCESS`,`PHY_ACC_GRT_DT`,`PHY_ACC_RV_DT`,\r\n" + 
	    		"`LOGICAL_ACCESS`,`LG_ACC_GRT_DT`,`LG_ACC_RV_DT`,`BIOMETRIC_ACCESS`,`BIO_ACC_GRT_DT`,\r\n" + 
	    		"`BIO_ACC_RV_DT`,`NOR_IND`,`NOR_IND_DATE`,`NOR_IND_ATTEMPT`,`CRIMINAL_BGV`,\r\n" + 
	    		"`CRIMINAL_BGV_DT`,`CRE_WR_BGV`,`CRE_WR_BGV_DT`,`EMP_BGV`,`EMP_BGV_DT`,\r\n" + 
	    		"`EDU_BGV`,`EDU_BGV_DT`,`START_DATE`,`END_DATE`,`MAKER_ID`,\r\n" + 
	    		"`STATUS`)\r\n" + 
	    		"VALUES\r\n" + 
	    		"(?,?,?,?,?,\r\n" + 
	    		"?,?,?,?,?,\r\n" + 
	    		"?,?,?,?,?,\r\n" + 
	    		"?,?,?,?,?,\r\n" + 
	    		"?,?,?,?,?,\r\n" + 
	    		"?)";
		try {
			 empcount=jdbcTemplate.update(queryToInsertPmoDetails,new Object[]
					 
			{
				emp.getPMO_ID(),emp.getPS_NO(),emp.getPHYSICAL_ACCESS(),emp.getPHY_ACC_GRT_DT(),emp.getPHY_ACC_RV_DT(),
				emp.getLOGICAL_ACCESS(),emp.getLG_ACC_GRT_DT(),emp.getLG_ACC_RV_DT(),emp.getBIOMETRIC_ACCESS(),emp.getBIO_ACC_GRT_DT(),
				emp.getBIO_ACC_RV_DT(),emp.getNOR_IND(),emp.getNOR_IND_DATE(),emp.getNOR_IND_ATTEMPT(),emp.getCRIMINAL_BGV(),
				emp.getCRIMINAL_BGV_DT(),emp.getCRE_WR_BGV(),emp.getCRE_WR_BGV_DT(),emp.getEMP_BGV(),emp.getEMP_BGV_DT(),
				emp.getEDU_BGV(),emp.getEDU_BGV_DT(),emp.getSTART_DATE(),emp.getEND_DATE(),emp.getMAKER_ID(),
				emp.getSTATUS()
				
				});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"PMO Details Not Created\"}";
		   }
	
		   return "{\"status\": \"Success\",\"reason\": \"PMO Details Inserted Successfully\"}";
	}

	@Override
	public String saveYubikeyDetails(Nor_yubikey_details emp) {
		int empcount=0;
		String queryToInsertYubikeyDetails="INSERT INTO `pmo`.`nor_yubikey_details`\r\n" + 
				"(`YUBIKEY_NO`,`YUBIKEY_ASSIGN_DATE`,`YUBIKEY_RELEASE_DATE`,`PS_NO`,`KID`,\r\n" + 
				"`START_DATE`,`END_DATE`,`MAKER_ID`,`STATUS`)\r\n" + 
				"VALUES\r\n" + 
				"(?,?,?,?,?,\r\n" + 
				"?,?,?,?)";
		try {
			 empcount=jdbcTemplate.update(queryToInsertYubikeyDetails,new Object[]
					 
			{
				emp.getYUBIKEY_NO(),emp.getYUBIKEY_ASSIGN_DATE(),emp.getYUBIKEY_RELEASE_DATE(),emp.getPS_NO(),emp.getKID(),
				emp.getSTART_DATE(),emp.getEND_DATE(), emp.getMAKER_ID(),emp.getSTATUS()
				});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"Yubikey Details Not Created\"}";
		   }
	
		return "{\"status\": \"Success\",\"reason\": \"Yubikey Details Created\"}";
	}

	@Override
	public String saveInventoryDetails(Nor_inventory_details emp) {
		int empcount=0;
		String queryToInsertInventoryDetails="INSERT INTO `pmo`.`nor_inventory_details`\r\n" + 
				"(`INV_ID`,`PS_NO`,`KID`,`YUBIKEY_NO`,`SEAT_NO`,`MONITOR_IV_NO_1`,\r\n" + 
				"`MONITOR_SERIAL_NO_1`,`MONITOR_IV_NO_2`,`MONITOR_SERIAL_NO_2`,`CPU_IV_NO`,`CPU_SERIAL_NO`,\r\n" + 
				"`HEADPHONE`,`DRAWER_KEY`,`START_DATE`,`END_DATE`,`MAKER_ID`,\r\n" + 
				"`STATUS`)\r\n" + 
				"VALUES\r\n" + 
				"(?,?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,\r\n" + 
				"?,?,?,?,?,\r\n" + 
				"?)";
		try {
			empcount=jdbcTemplate.update(queryToInsertInventoryDetails, new Object[] {
					emp.getINV_ID(),emp.getPS_NO(),emp.getKID(),emp.getSEAT_NO(),emp.getMONITOR_IV_NO_1(),
					emp.getMONITOR_SERIAL_NO_1(),emp.getMONITOR_IV_NO_2(),emp.getMONITOR_SERIAL_NO_2(),emp.getCPU_IV_NO(),emp.getCPU_SERIAL_NO(),
					emp.getHEADPHONE(),emp.getDRAWER_KEY(),emp.getSTART_DATE(),emp.getEND_DATE(),emp.getMAKER_ID(),
					emp.getSTATUS()
			});
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "{\"status\": \"Fail\",\"reason\": \"Inventory Details Not Created\"}";
		}
		return "{\"status\": \"Success\",\"reason\": \"Inventory Details Created\"}";
	}
}
