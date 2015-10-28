package edu.osu.cse5234.business;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService, Serializable {

	Inventory inventoryList;
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		inventoryList = new Inventory();
		
		addItem("Mass Effect", "10");
		addItem("Dragon Age", "10");
		addItem("Saints Row", "10");
		
		return inventoryList;
	}
	
	public void addItem(String title, String quantity){
		inventoryList.addItem(title,quantity);
	}
	
	@Override
	public boolean validateQuantity(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
