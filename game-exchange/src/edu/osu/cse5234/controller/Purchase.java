package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.QuantityWrapper;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;
import edu.osu.cse5234.validator.PaymentValidator;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	PaymentValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getSession().getAttribute("failed")=="true"){
			request.setAttribute("failed", true);
		}else{
			request.setAttribute("failed", false);
		}
		//checks for uncompleted order
		
		List<Item> inventory = ServiceLocator.getInventoryService().getAvailableInventory();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		for(int i = 0; i <inventory.size(); i++){
			quantity.add(0);
		}
		request.setAttribute("inventory", inventory);
		request.getSession().setAttribute("inventory", inventory);
		QuantityWrapper q = new QuantityWrapper();
		q.setQuantity(quantity);
		request.setAttribute("quantity",q );
		
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("quantity") QuantityWrapper quantity, HttpServletRequest request) {
		Order order = new Order();
		List<Item> inventory = (List<Item>) request.getSession().getAttribute("inventory");
		
		for(int i = 0; i < inventory.size(); i++){
			if(quantity.getQuantity().get(i)>0){
				order.addItem(inventory.get(i),quantity.getQuantity().get(i));
			}
		}
		
		request.getSession().setAttribute("order", order);
		//if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order)){
		//	
		//	request.getSession().setAttribute("failed", "false");
		//	return "redirect:/purchase/paymentEntry";
		//}
		//else{
		//	request.getSession().setAttribute("failed", "true");
		//	return "redirect:/purchase";
		//}
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, 
            BindingResult result, HttpServletRequest request, SessionStatus status) {
		request.getSession().setAttribute("payment", payment);

		// Validate form		
		//validator.validate(payment, result);
        
		// Check for validation errors
        //if (result.hasErrors()) {
        //    return "/submitPayment";
        //}
        
        // Mark session complete
        //status.setComplete();
        
		return "redirect:shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());	
		return "ShippingEntryForm";
	}

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
		return "ViewOrder";
	}	
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.POST)
	public String submitOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		return "redirect:confirmation";
	}
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("confirmation", ServiceLocator.getOrderProcessingService().processOrder((Order) request.getSession().getAttribute("order"), (PaymentInfo) request.getSession().getAttribute("payment"), (ShippingInfo) request.getSession().getAttribute("shipping")));
		return "Confirmation";
	}
}
