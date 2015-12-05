package edu.osu.cse5234.business.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM") 
public class Item implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int available_quantity;
	private double unit_price;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="ID")
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name="NAME")
	public String getName(){
		return name;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription(){
		return description;
	}

	public void setQuantity(int quantity){
		this.available_quantity = quantity;
	}
	
	@Column(name="AVAILABLE_QUANTITY")
	public int getQuantity(){
		return available_quantity;
	}

	public void setPrice(double price){
		this.unit_price = price;
	}
	
	@Column(name="UNIT_PRICE")
	public double getPrice(){
		return unit_price;
	}	
}
