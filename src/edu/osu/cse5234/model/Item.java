package edu.osu.cse5234.model;

public class Item implements java.io.Serializable {
	private String title;
	private String quantity;
	
	public Item() {
    }
 
    public Item(String title, String quantity) {
        this.title = title;
        this.quantity = quantity;
    }
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setQuantity(String quantity){
		this.quantity = quantity;
	}
	
	public String getQuantity(){
		return quantity;
	}
}
