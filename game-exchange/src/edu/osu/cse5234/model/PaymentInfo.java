package edu.osu.cse5234.model;

public class PaymentInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cardholder_name;
	private int cc_num;
	private String exp;
	private int ccv;
	private int customer_order_id;
	
	public PaymentInfo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardholder_name() {
		return cardholder_name;
	}

	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}

	public int getCc_num() {
		return cc_num;
	}

	public void setCc_num(int cc_num) {
		this.cc_num = cc_num;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public int getCustomer_order_id() {
		return customer_order_id;
	}

	public void setCustomer_order_id(int customer_order_id) {
		this.customer_order_id = customer_order_id;
	}
}
