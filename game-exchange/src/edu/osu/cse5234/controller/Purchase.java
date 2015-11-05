package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getSession().getAttribute("failed")=="true"){
			request.setAttribute("failed", true);
		}else{
			request.setAttribute("failed", false);
		}
		//checks for uncompleted order
		
		List<Item> inventory = ServiceLocator.getInventoryService().getAvailableInventory();
		request.setAttribute("inventory", inventory);
		request.setAttribute("quantity", new ArrayList<Integer>(inventory.size()));
		
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("inventory") List<Item> inventory, @ModelAttribute("quantity") List<Integer> quantity, HttpServletRequest request) {
		Order order = new Order();
		for(int i = 0; i < inventory.size(); i++){
			if(quantity.indexOf(i)>0){
				order.addItem(inventory.indexOf(i), quantity.indexOf(i));
			}
		}
		
		request.getSession().setAttribute("order", order);
		if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order)){
			
			request.getSession().setAttribute("failed", false);
			return "redirect:/purchase/paymentEntry";
		}
		else{
			request.getSession().setAttribute("failed", "true");
			return "redirect:/purchase";
		}
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
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
		//request.setAttribute("shipping", new PaymentInfo());	
		return "ViewOrder";
	}	
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.POST)
	public String submitOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		//request.getSession().setAttribute("order", order);
		request.getSession().setAttribute("confirmation", ServiceLocator.getOrderProcessingService().processOrder(order));
		return "redirect:confirmation";
	}
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		//request.setAttribute("shipping", new PaymentInfo());	
		return "Confirmation";
	}
}
