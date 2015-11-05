package edu.osu.cse5234.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Inventory inventoryList;
	
	@PersistenceContext private EntityManager entityManager;
	String MY_QUERY = "Select i from Item i";
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Item> getAvailableInventory() {		
		return entityManager.createQuery(MY_QUERY, Item.class).getResultList();
	}
	
	@Override
	public <LineItem> boolean validateQuantity(List<LineItem> orderList) {
		return true;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
