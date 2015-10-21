package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class Order implements java.io.Serializable {
	
	public List<Item> orderList;

	public Order() {
		orderList = new ArrayList<Item>();

		addItem("Mass Effect", "10");
		addItem("Dragon Age", "10");
		addItem("Saints Row", "10");
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
