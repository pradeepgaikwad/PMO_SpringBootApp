package com.nordea.pmo.spring.entity;



public class Nor_project_details {
	
	
	 String PROJECT_ID;
	String PROJECT_TYPE;
	
	
	String PROJECT_NAME;
	
	
	String START_DATE;
	
	
	String END_DATE;
	
	
	int MAKER_ID ;
	
	
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}

	public void setPROJECT_ID(String pROJECT_ID) {
		PROJECT_ID = pROJECT_ID;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	String STATUS;

	public String getPROJECT_TYPE() {
		return PROJECT_TYPE;
	}

	public void setPROJECT_TYPE(String pROJECT_TYPE) {
		PROJECT_TYPE = pROJECT_TYPE;
	}

	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}


	public int getMAKER_ID() {
		return MAKER_ID;
	}

	public void setMAKER_ID(int mAKER_ID) {
		MAKER_ID = mAKER_ID;
	}


	public String getSTATUS() {
		return STATUS;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}


}