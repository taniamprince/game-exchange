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
import edu.osu.cse5234.business.view.LineItem;

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

	List<Item> inventoryList;
	
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
	public Boolean validateQuantity(List<LineItem> orderList) {
		Boolean valid = Boolean.TRUE;
		inventoryList = getAvailableInventory();
		for (int i = 0; i < orderList.size(); i++){
			if (orderList.get(i).getQuantity() > inventoryList.get(i).getQuantity()){
				valid = Boolean.FALSE;
				break;
			}
		}
		return valid;
	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
