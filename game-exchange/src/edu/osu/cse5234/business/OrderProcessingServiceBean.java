package edu.osu.cse5234.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean implements Serializable {

	@PersistenceContext private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order, PaymentInfo payment, ShippingInfo shipping) {
    	entityManager.persist(order);
    	entityManager.persist(payment);
    	entityManager.persist(shipping);
    	entityManager.flush();
    	return "" + order.getId();
    }

    public boolean validateItemAvailability(Order order){	 	
    	//boolean validation = ServiceLocator.getInventoryService().validateQuantity(order.getOrderList());
    	//return validation;
    	return true;
    }
}
