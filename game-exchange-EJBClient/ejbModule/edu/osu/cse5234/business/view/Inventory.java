package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> inventoryList;
	
	
	public Inventory(){
		inventoryList = new ArrayList<Item>();
	}
	
	
	public void addItem(String title, String quantity){
		Item game = new Item(title,quantity);
		inventoryList.add(game);
	}
	
	public ArrayList<Item> getAvailableItems(){
		ArrayList<Item> available = new ArrayList<Item>();
		
		for(Iterator<Item> i = inventoryList.iterator(); i.hasNext();){
			Item temp = (Item) i.next();
			if(Integer.parseInt(temp.getQuantity())>0){
				available.add(temp);
			}
		}
		
		return available;
	}
}
