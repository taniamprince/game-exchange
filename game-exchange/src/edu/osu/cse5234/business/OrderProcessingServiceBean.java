package edu.osu.cse5234.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
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
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class) 
public class OrderProcessingServiceBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
	private String customerEmail;

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
     
    private void notifyUser(){
    	String message = customerEmail + ":" +
     	       "Your order was successfully submitted. " + 
     	       "You will hear from us when items are shipped. " + 
     	      	new Date();

     	System.out.println("Sending message: " + message);
     	jmsContext.createProducer().send(queue, message);
     	System.out.println("Message Sent!");
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
    	payment.setCustomer_order_id_fk(order.getId());
    	shipping.setCustomer_order_id_fk(order.getId());
    	entityManager.persist(payment);
    	entityManager.persist(order);
    	entityManager.flush();
    	notifyUser();
    	return "" + order.getId();
    }

    public Boolean validateItemAvailability(Order order){	 	
    	//return ServiceLocator.getInventoryService().validateQuantity(order.getOrderList());
    	return true;
    }
}
