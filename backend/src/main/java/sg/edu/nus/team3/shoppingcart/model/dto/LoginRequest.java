package sg.edu.nus.team3.shoppingcart.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @authored Dion Yao
 */

public class LoginRequest {

	@NotBlank(message = "Email is required")
	// I looked up online for this email regex validation, because I knew it exists
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
		    message = "Invalid email format"
		)	
	private String email;
	
	// Looked up online for classic password regex validation
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include uppercase and lowercase letters, a number, and a special character"
        )
	private String password;
	
	public LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;	
	}
	
	public LoginRequest() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
