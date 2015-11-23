package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	private String item_name;
	private int quantity;
	private int customer_order_id_fk;
	
	public LineItem(){
		
	}
	
	public LineItem(Item item, int cust_id, int quantity){
		
		id = item.getID();
		item_name = item.getName();
	    this.quantity = quantity;
	    customer_order_id_fk = cust_id;
	    
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="ID")
	public int getId(){
		return id;
	}
	
	public void setItem_name(String name){
		this.item_name = name;
	}
	
	@Column(name="ITEM_NAME")
	public String getItem_name(){
		return item_name;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	@Column(name="QUANTITY")
	public int getQuantity(){
		return quantity;
	}
		
	public void setCustomer_order_id_fk(int id){
		this.customer_order_id_fk = id;
	}
	
	@Column(name="CUSTOMER_ORDER_ID_FK")
	public int getCustomer_order_id_fk(){
		return customer_order_id_fk;
	}
}
