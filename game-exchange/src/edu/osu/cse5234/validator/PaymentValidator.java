package edu.osu.cse5234.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return PaymentValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object PaymentInfo, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "cardholder_name", "required.cardholder_name");	
	}

}
