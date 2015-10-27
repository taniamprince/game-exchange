package edu.osu.cse5234.business.view;

public class Item implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String quantity;
	
 
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
