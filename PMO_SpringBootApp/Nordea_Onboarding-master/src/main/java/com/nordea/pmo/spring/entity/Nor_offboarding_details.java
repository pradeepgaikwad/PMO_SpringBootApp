//package com.nordea.pmo.spring.entity;
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="Nor_offboarding_details")
//public class Nor_offboarding_details {
//	
//	@Id	
//	@Column(name="OFFBOARD_ID")
//	  private int OFFBOARD_ID; 
//	
//	@Column(name="BILL_END_DATE")
//	  private Date BILL_END_DATE;
//	
//	@Column(name="EDC_END_DATE")
//	  private Date EDC_END_DATE ;
//	
//	@Column(name="PRF_LEVEL")
//	  private String PRF_LEVEL ;
//	
//	@Column(name="REL_OR_RES")
//	  private String REL_OR_RES ;
//	
//	@Column(name="REASON")
//	  private String REASON ;
//	
//	@Column(name="CATEGORY")
//	  private String CATEGORY;
//	
//	@Column(name="REP_PR_NO")
//	  private String REP_PR_NO;
//	
//	@Column(name="REASON_NO_REP")
//	  private String REASON_NO_REP;
//	
//	@Column(name="YUBIKEY_RETURN")
//	  private String YUBIKEY_RETURN;
//	
//	@Column(name="VDI_ACC_RM")
//	  private String VDI_ACC_RM ;
//	
//	@Column(name="OTH_ACC_RM")
//	  private String OTH_ACC_RM ;
//	
//	@Column(name="HEADSET_RETURN")
//	  private String HEADSET_RETURN;
//	
//	@Column(name="START_DATE")
//	  private Date START_DATE ;
//	
//	@Column(name="END_DATE")
//	  private Date END_DATE ;
//	
//	@Column(name="MAKER_ID")
//	  private int MAKER_ID ;
//	
//	@Column(name="STATUS")
//	  private String STATUS;
//	
//	
//	public int getOFFBOARD_ID() {
//		return OFFBOARD_ID;
//	}
//	public void setOFFBOARD_ID(int oFFBOARD_ID) {
//		OFFBOARD_ID = oFFBOARD_ID;
//	}
//	
//	public Date getBILL_END_DATE() {
//		return BILL_END_DATE;
//	}
//	public void setBILL_END_DATE(Date bILL_END_DATE) {
//		BILL_END_DATE = bILL_END_DATE;
//	}
//	public Date getEDC_END_DATE() {
//		return EDC_END_DATE;
//	}
//	public void setEDC_END_DATE(Date eDC_END_DATE) {
//		EDC_END_DATE = eDC_END_DATE;
//	}
//	public String getPRF_LEVEL() {
//		return PRF_LEVEL;
//	}
//	public void setPRF_LEVEL(String pRF_LEVEL) {
//		PRF_LEVEL = pRF_LEVEL;
//	}
//	public String getREL_OR_RES() {
//		return REL_OR_RES;
//	}
//	public void setREL_OR_RES(String rEL_OR_RES) {
//		REL_OR_RES = rEL_OR_RES;
//	}
//	public String getREASON() {
//		return REASON;
//	}
//	public void setREASON(String rEASON) {
//		REASON = rEASON;
//	}
//	public String getCATEGORY() {
//		return CATEGORY;
//	}
//	public void setCATEGORY(String cATEGORY) {
//		CATEGORY = cATEGORY;
//	}
//	public String getREP_PR_NO() {
//		return REP_PR_NO;
//	}
//	public void setREP_PR_NO(String rEP_PR_NO) {
//		REP_PR_NO = rEP_PR_NO;
//	}
//	public String getREASON_NO_REP() {
//		return REASON_NO_REP;
//	}
//	public void setREASON_NO_REP(String rEASON_NO_REP) {
//		REASON_NO_REP = rEASON_NO_REP;
//	}
//	public String getYUBIKEY_RETURN() {
//		return YUBIKEY_RETURN;
//	}
//	public void setYUBIKEY_RETURN(String yUBIKEY_RETURN) {
//		YUBIKEY_RETURN = yUBIKEY_RETURN;
//	}
//	public String getVDI_ACC_RM() {
//		return VDI_ACC_RM;
//	}
//	public void setVDI_ACC_RM(String vDI_ACC_RM) {
//		VDI_ACC_RM = vDI_ACC_RM;
//	}
//	public String getOTH_ACC_RM() {
//		return OTH_ACC_RM;
//	}
//	public void setOTH_ACC_RM(String oTH_ACC_RM) {
//		OTH_ACC_RM = oTH_ACC_RM;
//	}
//	public String getHEADSET_RETURN() {
//		return HEADSET_RETURN;
//	}
//	public void setHEADSET_RETURN(String hEADSET_RETURN) {
//		HEADSET_RETURN = hEADSET_RETURN;
//	}
//	public Date getSTART_DATE() {
//		return START_DATE;
//	}
//	public void setSTART_DATE(Date sTART_DATE) {
//		START_DATE = sTART_DATE;
//	}
//	public Date getEND_DATE() {
//		return END_DATE;
//	}
//	public void setEND_DATE(Date eND_DATE) {
//		END_DATE = eND_DATE;
//	}
//	public int getMAKER_ID() {
//		return MAKER_ID;
//	}
//	public void setMAKER_ID(int mAKER_ID) {
//		MAKER_ID = mAKER_ID;
//	}
//	public String getSTATUS() {
//		return STATUS;
//	}
//	public void setSTATUS(String sTATUS) {
//		STATUS = sTATUS;
//	}
//	@Override
//	public String toString() {
//		return "nor_offboarding_details [OFFBOARD_ID=" + OFFBOARD_ID  + ", BILL_END_DATE="
//				+ BILL_END_DATE + ", EDC_END_DATE=" + EDC_END_DATE + ", PRF_LEVEL=" + PRF_LEVEL + ", REL_OR_RES="
//				+ REL_OR_RES + ", REASON=" + REASON + ", CATEGORY=" + CATEGORY + ", REP_PR_NO=" + REP_PR_NO
//				+ ", REASON_NO_REP=" + REASON_NO_REP + ", YUBIKEY_RETURN="
//				+ YUBIKEY_RETURN + ", VDI_ACC_RM=" + VDI_ACC_RM + ", OTH_ACC_RM=" + OTH_ACC_RM + ", HEADSET_RETURN="
//				+ HEADSET_RETURN + ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", MAKER_ID=" + MAKER_ID
//				+ ", STATUS=" + STATUS + "]";
//	}
//	  
//	@OneToOne(cascade=CascadeType.DETACH)
//	@JoinColumn(name="PS_NO")
//	  private Nor_emp_details nor_emp_details;
//	
//	public Nor_emp_details getNor_emp_details() {
//		return nor_emp_details;
//	}
//	public void setNor_emp_details(Nor_emp_details nor_emp_details) {
//		this.nor_emp_details = nor_emp_details;
//	}
//
//	@OneToOne(cascade=CascadeType.DETACH)
//	@JoinColumn(name="YUBIKEY_NO")
//	private Nor_yubikey_details nor_yubikey_details;
//
//	public Nor_yubikey_details getNor_yubikey_details() {
//		return nor_yubikey_details;
//	}
//	public void setNor_yubikey_details(Nor_yubikey_details nor_yubikey_details) {
//		this.nor_yubikey_details = nor_yubikey_details;
//	} 
//	
//}
