package com.nordea.pmo.spring.entity;



public class Pmo_auth_details {

int	AUTH_ID ;	

int USER_ID; 	

String PASSWORD ;

String AUTH_ROLE;

String START_DATE;

String END_DATE;


public int getAUTH_ID() {
	return AUTH_ID;
}

public void setAUTH_ID(int aUTH_ID) {
	AUTH_ID = aUTH_ID;
}

public int getUSER_ID() {
	return USER_ID;
}

public void setUSER_ID(int uSER_ID) {
	USER_ID = uSER_ID;
}

public String getPASSWORD() {
	return PASSWORD;
}

public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}

public String getAUTH_ROLE() {
	return AUTH_ROLE;
}

public void setAUTH_ROLE(String aUTH_ROLE) {
	AUTH_ROLE = aUTH_ROLE;
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
