package edu.osu.cse5234.model;
import java.util.List;
import edu.osu.cse5234.business.view.LineItem;

public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String customer_name;
	private String customer_email;
	private String status;
	public List<LineItem> orderList;
	    
	public Order() {

    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
