package edu.osu.cse5234.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;
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
	
	@WebServiceRef(wsdlLocation =
			"http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;
	
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order, PaymentInfo payment, ShippingInfo shipping) {
    	CreditCardPayment ccp = new CreditCardPayment();
    	ccp.setCardholderName(payment.getCardholder_name());
    	ccp.setCcNum(payment.getCc_num());
    	ccp.setCcv(payment.getCcv());
    	ccp.setExp(payment.getExp());
    	int paymentNumber = Integer.parseInt(service.getPaymentProcessorPort().processPayment(ccp));
    	if (paymentNumber >= 0) {
    		payment.setConformationNumber(paymentNumber);
    		order.setStatus("Pending");
    		entityManager.persist(order);
    		entityManager.persist(payment);
    		entityManager.persist(shipping);
    		entityManager.flush();
    	}
    	else {
    		System.out.println("paymentNumber < 0");
    	}
    	return "" + order.getId();
    }

    public boolean validateItemAvailability(Order order){	 	
    	//boolean validation = ServiceLocator.getInventoryService().validateQuantity(order.getOrderList());
    	//return validation;
    	return true;
    }
}
