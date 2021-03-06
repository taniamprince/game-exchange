package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	private int customer_order_id_fk;
	private String invalid;
	public ShippingInfo(){
		invalid = "";
	}

	@Column(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="ADDRESS1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name="ADDRESS2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="ZIP")
	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getZipString(){
		return zip+"";
	}
	public void setZipString(String zip){
		try{
			this.zip = Integer.parseInt(zip);
		}catch(Exception e){
			if(invalid.equals("")){
				invalid = "zip";
			}else{
				invalid = invalid +", zip";
			}
		}
	}

	public int getCustomer_order_id_fk() {
		return customer_order_id_fk;
	}

	public void setCustomer_order_id_fk(int customer_order_id_fk) {
		this.customer_order_id_fk = customer_order_id_fk;
	}
		
}
