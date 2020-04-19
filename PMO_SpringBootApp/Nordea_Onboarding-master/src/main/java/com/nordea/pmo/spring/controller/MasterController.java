package com.nordea.pmo.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nordea.pmo.spring.entity.Pmo_auth_details;
import com.nordea.pmo.spring.service.MasterService;
import com.nordea.pmo.spring.utility.EmailUtil;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MasterController {
	
	@Autowired
	MasterService masterService;

	@Autowired
	EmailUtil emailutil;
	
	@RequestMapping(value="test")
	public String testapi() {
		return "hello";
	}
	
	

	 @RequestMapping(value ="/login",method=RequestMethod.POST)
	 public List loginWeb(@RequestBody String loginForm)
	 {
		 Pmo_auth_details pmo_auth_details=new Pmo_auth_details();

		 List loginStatus=masterService.login(loginForm);
		   System.out.println("loginStatus   "+loginStatus);
		   
				/* if(loginStatus.equalsIgnoreCase("true"))
				 {
						return "login successfully ";
				  }else {
					 
				   return "login denied...!!";
					}*/
					 
		 
		    return loginStatus;
				  
	 }
	 
	 //CURD OPERATION IN SPRING ANGUALR
	 
	   /***********Create employee API**********/ 
	 @RequestMapping(value="/createemployee",method=RequestMethod.POST, headers="accept=application/json")
		public ResponseEntity<?> createEmployeeApi(@RequestBody String empDetails){
		 System.out.println("-----------jsonObject--"+empDetails);
             String empResponse = masterService.saveEmployee(empDetails);  
             emailutil.sendItinerary("pradeepgaikwad994@gmail.com", "Hello");
			return new ResponseEntity<>(empResponse,HttpStatus.OK);
			
		}
	 
	 /*****************************Insert On-board Details**************************************************/
	//onboardForm
	 @RequestMapping(value="/insertonboard",method=RequestMethod.POST, headers="accept=application/json")
	// @PostMapping("/insertonboard")
	// @RequestMapping(value=("/insertonboard"),method=RequestMethod.POST)
	 public String onboardemployee(
			// @RequestParam("onboardForm") String onboardForm,
			 @RequestParam("resumeFile") MultipartFile resumeFile
			// @RequestParam("ndaFile") MultipartFile ndaFile
			){
		// System.out.println("*******onboardForm*******"+onboardForm);
		 System.out.println("*******resumeFile********"+resumeFile);
            
		// String emponboardresponse=masterService.saveOnboardEmployeeDetails(onboardForm,resumeFile,ndaFile);
		// return new ResponseEntity<>(emponboardresponse,HttpStatus.OK);
		 return "success";
	 }
	 
	 /*****************************Insert Project Details**************************************************/
	 
	 @RequestMapping(value="/insertproject",method=RequestMethod.POST, headers="accept=application/json")
	 public ResponseEntity<?> projectdetailsemployee(@RequestBody String projectdetailsemp){
		 System.out.println("*******Project Employee Jason Objetc********"+projectdetailsemp);
		 String empprojectresponse=masterService.saveProjectDetails(projectdetailsemp);
		 return new ResponseEntity<>(empprojectresponse,HttpStatus.OK);
	 }
	 
	 
	 /*****************************Insert PMO Details**************************************************/
	 
	 @RequestMapping(value="/insertpmo",method=RequestMethod.POST, headers="accept=application/json")
	 public ResponseEntity<?> pmodetailsemployee(@RequestBody String pmodetails){
		 System.out.println("*******PMO Employee Jason Objetc********"+pmodetails);
		 String emppmoresponse=masterService.savePmoDetails(pmodetails);
		 return new ResponseEntity<>(emppmoresponse,HttpStatus.OK);
	 }
	 
	 
	 /*****************************Insert Yubikey Details**************************************************/
	 
	 @RequestMapping(value="/insertyubikey",method=RequestMethod.POST, headers="accept=application/json")
	 public ResponseEntity<?> yubikeydetailsemployee(@RequestBody String yubikeydetails){
		 System.out.println("*******Yubikey Employee Jason Objetc********"+yubikeydetails);
		 String empyubikeyresponse=masterService.saveYubikeyDetails(yubikeydetails);
		 return new ResponseEntity<>(empyubikeyresponse,HttpStatus.OK);
	 }

	 /*****************************Insert Inventory Details**************************************************/
	 
	 @RequestMapping(value="/insertinventory",method=RequestMethod.POST, headers="accept=application/json")
	 public ResponseEntity<?> inventorydetailsemployee(@RequestBody String inventorydetails){
		 System.out.println("*******Inventory Employee Jason Objetc********"+inventorydetails);
		 String empinventoryresponse=masterService.saveInventoryDetails(inventorydetails);
		 return new ResponseEntity<>(empinventoryresponse,HttpStatus.OK);
	 }
	 
		/***********Get employee API**********/ 

		@RequestMapping(value="/getparticularemployee",method=RequestMethod.GET, headers="accept=application/json")
		public ResponseEntity<?> getParticularEmployee(@RequestParam String id){
			String empInformation = null;
			empInformation = masterService.getParticularEmployee(id);
			return new ResponseEntity<>(empInformation, HttpStatus.OK);
		}

		/***********update employee API**********/ 
		@RequestMapping(value="/updateemployee",method=RequestMethod.PUT, headers="accept=application/json")
		public ResponseEntity<?> updateemployees(@RequestBody String empRecord,@RequestParam int id ){



			String empUpdateResponse = masterService.updateEmployee(empRecord,id);
			
			return new ResponseEntity<>(empUpdateResponse,HttpStatus.OK);
		}

		/***********Delete employee API**********/ 
		
		@RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE, headers="accept=application/json")
		public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {

			String empDeleteResponse = masterService.deleteEmployee(id);
			
			return new ResponseEntity<>(empDeleteResponse,HttpStatus.OK);
		}

		/***********GET ALL  employee API**********/ 
		@RequestMapping(value="/getallemployees",method=RequestMethod.GET, headers="accept=application/json")
		public ResponseEntity<?> getAllEmployee(){
			String infoInformation = null;
			infoInformation = masterService.getListOfEmployee();
			return new ResponseEntity<>(infoInformation, HttpStatus.OK);
		}

	
	
}
