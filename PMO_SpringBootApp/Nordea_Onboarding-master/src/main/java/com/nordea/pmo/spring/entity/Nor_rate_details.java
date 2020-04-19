//package com.nordea.pmo.spring.entity;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="Nor_rate_details")
//public class Nor_rate_details {
//	
//	@Id
//	@Column(name="NOR_ROLE")
//	private String NOR_ROLE ;
//	
//	@Column(name="NOR_DESP")
//	private String  NOR_DESP ;
//	
//	@Column(name="COUNTRY")
//	private String  COUNTRY ;
//	
//	@Column(name="ONSITE_RATE")
//	private float  ONSITE_RATE;
//	
//	@Column(name="OT_ON_RATE")
//	private float  OT_ON_RATE;
//	
//	@Column(name="HOL_ON_RATE")
//	private float  HOL_ON_RATE;
//	
//	@Column(name="OFFSHORE_RATE")
//	private float  OFFSHORE_RATE;
//	
//	@Column(name="OT_OFF_RATE")
//	private float  OT_OFF_RATE; 
//	
//	@Column(name="HOL_OFF_RATE")
//	private float  HOL_OFF_RATE;
//	
//	@Column(name="START_DATE")
//	private Date  START_DATE;
//	
//	@Column(name="END_DATE")
//	private Date  END_DATE; 
//	
//	@Column(name="MAKER_ID")
//	private int MAKER_ID;
//	
//	@Column(name="STATUS")
//	private String  STATUS;
//	
//	//Getters & Setters
//	public String getNOR_ROLE() {
//		return NOR_ROLE;
//	}
//	public void setNOR_ROLE(String nOR_ROLE) {
//		NOR_ROLE = nOR_ROLE;
//	}
//	public String getNOR_DESP() {
//		return NOR_DESP;
//	}
//	public void setNOR_DESP(String nOR_DESP) {
//		NOR_DESP = nOR_DESP;
//	}
//	public String getCOUNTRY() {
//		return COUNTRY;
//	}
//	public void setCOUNTRY(String cOUNTRY) {
//		COUNTRY = cOUNTRY;
//	}
//	public float getONSITE_RATE() {
//		return ONSITE_RATE;
//	}
//	public void setONSITE_RATE(float oNSITE_RATE) {
//		ONSITE_RATE = oNSITE_RATE;
//	}
//	public float getOT_ON_RATE() {
//		return OT_ON_RATE;
//	}
//	public void setOT_ON_RATE(float oT_ON_RATE) {
//		OT_ON_RATE = oT_ON_RATE;
//	}
//	public float getHOL_ON_RATE() {
//		return HOL_ON_RATE;
//	}
//	public void setHOL_ON_RATE(float hOL_ON_RATE) {
//		HOL_ON_RATE = hOL_ON_RATE;
//	}
//	public float getOFFSHORE_RATE() {
//		return OFFSHORE_RATE;
//	}
//	public void setOFFSHORE_RATE(float oFFSHORE_RATE) {
//		OFFSHORE_RATE = oFFSHORE_RATE;
//	}
//	public float getOT_OFF_RATE() {
//		return OT_OFF_RATE;
//	}
//	public void setOT_OFF_RATE(float oT_OFF_RATE) {
//		OT_OFF_RATE = oT_OFF_RATE;
//	}
//	public float getHOL_OFF_RATE() {
//		return HOL_OFF_RATE;
//	}
//	public void setHOL_OFF_RATE(float hOL_OFF_RATE) {
//		HOL_OFF_RATE = hOL_OFF_RATE;
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
//		return "nor_rate_details [NOR_ROLE=" + NOR_ROLE + ", NOR_DESP=" + NOR_DESP + ", COUNTRY=" + COUNTRY
//				+ ", ONSITE_RATE=" + ONSITE_RATE + ", OT_ON_RATE=" + OT_ON_RATE + ", HOL_ON_RATE=" + HOL_ON_RATE
//				+ ", OFFSHORE_RATE=" + OFFSHORE_RATE + ", OT_OFF_RATE=" + OT_OFF_RATE + ", HOL_OFF_RATE=" + HOL_OFF_RATE
//				+ ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", MAKER_ID=" + MAKER_ID + ", STATUS="
//				+ STATUS + "]";
//	}
//	
//	@OneToOne(mappedBy="nor_rate_details")
//	private Nor_emp_details nor_emp_details;
//
//	
//}
