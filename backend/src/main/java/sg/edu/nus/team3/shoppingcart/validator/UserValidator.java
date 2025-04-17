package sg.edu.nus.team3.shoppingcart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.nus.team3.shoppingcart.model.User;

@Component
public class UserValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		
		
		
		
	}
	
	
	
	
}
