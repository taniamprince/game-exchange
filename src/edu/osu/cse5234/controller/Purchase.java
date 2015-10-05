package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("order", new Order());
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("order", new Order());
		//request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("order") Order order, HttpServletRequest request) {
		//request.getSession().setAttribute("order", order);
		return "redirect:shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		//request.setAttribute("shipping", new PaymentInfo());	
		return "ShippingEntryForm";
	}

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("order") Order order, HttpServletRequest request) {
		//request.getSession().setAttribute("order", order);
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
		return "redirect:confirmation";
	}
	
	@RequestMapping(path = "/confirmation", method = RequestMethod.GET)
	public String viewConfirmationPage(HttpServletRequest request, HttpServletResponse response) {
		//request.setAttribute("shipping", new PaymentInfo());	
		return "Confirmation";
	}
}
