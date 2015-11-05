package edu.osu.cse5234.model;

public class ShippingInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	private int customer_order_id;
	
	public ShippingInfo(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getCustomer_order_id() {
		return customer_order_id;
	}

	public void setCustomer_order_id(int customer_order_id) {
		this.customer_order_id = customer_order_id;
	}
	
}
