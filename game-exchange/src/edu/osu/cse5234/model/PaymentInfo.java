package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	private String cardholder_name;
	private int cc_num;
	private String exp;
	private int ccv;
	private int customer_order_id_fk;
	
	public PaymentInfo(){
		
	}

	@Column(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="CARDHOLDER_NAME")
	public String getCardholder_name() {
		return cardholder_name;
	}

	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}

	@Column(name="CC_NUM")
	public int getCc_num() {
		return cc_num;
	}

	public void setCc_num(int cc_num) {
		this.cc_num = cc_num;
	}
	
	public String getCc_numString(){
		String ccNum = "";
		if(cc_num !=0){
			ccNum = ""+cc_num;
		}
		return ccNum;
	}
	public void setCc_numString(String ccNum){
		if(ccNum!=""){
		cc_num = Integer.parseInt(ccNum);
		}else{
			cc_num = 0;
		}
	}

	@Column(name="EXP")
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	@Column(name="CCV")
	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public String getCcvString() {
		String ccvString = "";
		if(ccv!=0){
			ccvString = ""+ccv;
		}
		return ccvString;
	}

	public void setCcvString(String ccv) {
		if(ccv==""){
			this.ccv = 0;
		}else{
			this.ccv = Integer.parseInt(ccv);
		}
	}
	
	@Column(name="CUSTOMER_ORDER_ID_FK")
	public int getCustomer_order_id() {
		return customer_order_id_fk;
	}

	public void setCustomer_order_id(int customer_order_id) {
		this.customer_order_id_fk = customer_order_id;
	}
}
