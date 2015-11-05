package edu.osu.cse5234.business.view;

public class LineItem {
	private int id;
	private int item_id;
	private String item_name;
	private int quantity;
	private int customer_order_id_fk;
	
	public LineItem(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setItem_id(int id){
		this.item_id = id;
	}
	
	public int getItem_id(){
		return item_id;
	}
	
	public void setItem_name(String name){
		this.item_name = name;
	}
	
	public String getItem_name(){
		return item_name;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setCustomer_order_id_fk(int id){
		this.customer_order_id_fk = id;
	}
	
	public int getCustomer_order_id_fk(){
		return customer_order_id_fk;
	}
}
