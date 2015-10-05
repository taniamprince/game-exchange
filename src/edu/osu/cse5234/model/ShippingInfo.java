package edu.osu.cse5234.model;

public class ShippingInfo implements java.io.Serializable {
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	
	public void setAddress1(String address){
		this.address1 = address;
	}
	
	public String getAddress1(){
		return address1;
	}
	
	public void setAddress2(String address){
		this.address2 = address;
	}
	
	public String getAddress2(){
		return address2;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public String getState(){
		return state;
	}
	
	public void setZip(String zip){
		this.zip = zip;
	}
	
	public String getZip(){
		return zip;
	}
}
