package com.chase.payment;

public class PaymentProcessor {

	public String ping() {
		return "I am alive";
	}
	
	public String processPayment(CreditCardPayment payment) {
		return "1";
	}
	
}
