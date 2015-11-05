package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;

public class Order implements java.io.Serializable {
	
	public List<Item> orderList;

	public Order() {

    }

	public void addItem(String title, String quantity){
		//Item game = new Item(title,quantity);
		//orderList.add(game);
	}
	
    public void setOrderList(ArrayList<Item> orderList) {
        this.orderList = orderList;
    }
	
	public List<Item> getOrderList(){
		return this.orderList;
	}
	
	
}
