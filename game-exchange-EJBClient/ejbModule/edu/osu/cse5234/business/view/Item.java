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
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private int quantity;
	private double price;
	
	
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="ID")
	public int getID(){
		return id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	@Column(name="TITLE")
	public String getTitle(){
		return title;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription(){
		return description;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	@Column(name="AVAILABLE_QUANTITY")
	public int getQuantity(){
		return quantity;
	}

	public void setPrice(double price){
		this.price = price;
	}
	
	@Column(name="UNIT_PRICE")
	public double getPrice(){
		return price;
	}	
}
