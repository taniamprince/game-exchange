package edu.osu.cse5234.business.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM") 
public class Item implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String description;
	private int quantity;
	private double price;
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	@Column(name="TITLE")
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	@Column(name="DESCRIPTION")
	public void setDescription(String desc){
		this.description = desc;
	}
	
	public String getDescription(){
		return description;
	}
	
	@Column(name="AVAILABLE_QUANTITY")
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	@Column(name="UNIT_PRICE")
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}	
}
