package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

	private ArrayList<Item> inventoryList;
	
	
	public Inventory(){
		inventoryList = new ArrayList<Item>();
		
		addItem("Mass Effect", "10");
		addItem("Dragon Age", "10");
		addItem("Saints Row", "10");
	}
	
	
	public void addItem(String title, String quantity){
		Item game = new Item(title,quantity);
		inventoryList.add(game);
	}
	
	public ArrayList<Item> getAvailableItems(){
		ArrayList<Item> available = new ArrayList<Item>();
		
		for(Iterator<Item> i = available.iterator(); i.hasNext();){
			Item temp = (Item) i.next();
			if(Integer.parseInt(temp.getQuantity())>0){
				available.add(temp);
			}
		}
		
		return available;
	}
}
