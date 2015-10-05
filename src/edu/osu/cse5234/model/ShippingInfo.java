package edu.osu.cse5234.model;

public class ShippingInfo implements java.io.Serializable {
	private String ccNum;
	private String expDate;
	private String ccvCode;
	private String name;
	
	public void setCCNum(String ccNum){
		this.ccNum = ccNum;
	}
	
	public String getCCNum(){
		return ccNum;
	}
	
	public void setExpDate(String expDate){
		this.expDate = expDate;
	}
	
	public String getExpDate(){
		return expDate;
	}
	
	public void setCCVCode(String ccvCode){
		this.ccvCode = ccvCode;
	}
	
	public String getCCVCode(){
		return ccvCode;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
