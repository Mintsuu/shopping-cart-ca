package sg.edu.nus.team3.shoppingcart.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @authored Dion Yao
 */

public class RegisterRequest {
	//All validations copy and pasted from User entity
	
	@NotBlank(message = "Email is required")
	// I looked up online for this email regex validation, because I knew it exists
	@Pattern(
		    regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
		    message = "Invalid email format"
		)	
	private String email;
	
	@NotBlank(message = "Password is required")
	// Looked up online for classic password regex validation
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include uppercase and lowercase letters, a number, and a special character"
        )
	private String password;
	
	
	@NotBlank(message = "First name is required")
	@Size(max = 35, message = "First name must not be more than 35 characters")
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Size(max = 35, message = "Last name must not be more than 35 characters")
	private String lastName;
	
	@NotBlank(message = "Handphone no. is required")
	@Size(min = 8, max = 8, message = "Handphone no. must be 8 digits")
	private String handPhoneNo;
	
	@NotBlank(message = "Address is required")
	private String address;

	public RegisterRequest() {

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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHandPhoneNo() {
		return handPhoneNo;
	}
	public void setHandPhoneNo(String handPhoneNo) {
		this.handPhoneNo = handPhoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
