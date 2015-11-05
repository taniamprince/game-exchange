package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	return "1";
    }

    public boolean validateItemAvailability(Order order){	 	
    	return ServiceLocator.getInventoryService().validateQuantity(order.orderList);  	  	
    }
}
