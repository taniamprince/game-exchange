package edu.osu.cse5234.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.osu.cse5234.business.view.LineItem;

@Entity
@Table(name="CUSTOMER_ORDER") 
public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	private String customer_name;
	private String customer_email;
	private String status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> orderList;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<PaymentInfo> paymentInfoList;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<ShippingInfo> shippingInfoList;
	    
	public Order() {

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="CUSTOMER_NAME")
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Column(name="CUSTOMER_EMAIL")
	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LineItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<LineItem> orderList) {
		this.orderList = orderList;
	}

	private List<PaymentInfo> getPaymentInfoList() {
		return paymentInfoList;
	}

	private void setPaymentInfoList(List<PaymentInfo> paymentInfoList) {
		this.paymentInfoList = paymentInfoList;
	}

	private List<ShippingInfo> getShippingInfoList() {
		return shippingInfoList;
	}

	private void setShippingInfoList(List<ShippingInfo> shippingInfoList) {
		this.shippingInfoList = shippingInfoList;
	}
}
