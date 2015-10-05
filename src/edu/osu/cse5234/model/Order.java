package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class Order implements java.io.Serializable {
	
	private List<Item> orderList;

	public Order() {
		orderList = new ArrayList<Item>();
    }
	
	public void addItem(String title, String quantity){
		Item game = new Item(title,quantity);
		orderList.add(game);
	}
	
    public void setOrderList(List<Item> orderList) {
        this.orderList = orderList;
    }
	
	public List<Item> getOrderList(){
		return orderList;
	}
}
