package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface InventoryService extends Serializable {

	public List<Item> getAvailableInventory();
	
	public boolean validateQuantity(List<LineItem> orderList);
	
	public boolean updateInventory(Collection<Item> items);
	
}
