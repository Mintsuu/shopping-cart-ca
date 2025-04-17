package sg.edu.nus.team3.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.model.dto.LoginRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.RegisterRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.UpdateUserRequest;
import sg.edu.nus.team3.shoppingcart.service.UserService;
import sg.edu.nus.team3.shoppingcart.util.APIResponse;

/**
@author Dion Yao
 */

@RestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	/* 
	 * This section is for Login / Login status / Logout
	 * 
	 */

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request, HttpSession session) {

		Optional<User> userOpt = userService.findUserByEmail(request.getEmail());

		// Log users in if email exists in database, and associated password matches
		// on successful login, updates session with "id", "role", and "cartId" attributes

		if (userService.loginAttempt(request)) {
			User user = userOpt.get();

			session.setAttribute("id", user.getId());
			session.setAttribute("role", user.getRole());
			session.setAttribute("cartId", user.getShoppingCart().getId());

			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		APIResponse resp = new APIResponse("Invalid email or password.");
		return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);
	}


	@GetMapping("/status")
	public ResponseEntity<?> checkLoginStatus(HttpSession session) {

		Object userId = session.getAttribute("id");

		if (userId == null) {
			APIResponse resp = new APIResponse("You are not logged in");
			return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);
		}

		APIResponse resp = new APIResponse("You are logged in");
		return new ResponseEntity<>(resp, HttpStatus.OK);

	}


	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {

		// Deletes all information in current session, and locks users out of application till next login
		session.invalidate();

		APIResponse resp = new APIResponse("You have logged out successfully");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	/*
	 * This section is CRUD functions for customer account
	 */

	@PostMapping("/register/customer")
	public ResponseEntity<?> registerCustomer(@Valid @RequestBody RegisterRequest request) {


		try {
			User newUser = userService.registerCustomer(request);
			return new ResponseEntity<User> (newUser, HttpStatus.CREATED);

		} catch (Exception e) {
			APIResponse resp = new APIResponse("Unable to register account");
			return new ResponseEntity<>(resp, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/profile")
	public ResponseEntity<?> getMyAccount(HttpSession session) {

		int userId = (int) session.getAttribute("id");


		User user = userService.findUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	@PutMapping("/profile")
	public ResponseEntity<?> updateMyProfile(@Valid @RequestBody UpdateUserRequest request, HttpSession session) {

		// Get userId
		int userId = (int) session.getAttribute("id");

		User updatedUser = userService.updateUser(userId, request);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}


	@DeleteMapping("/profile")
	public ResponseEntity<?> deleteMyProfile(HttpSession session) {

		// Get userId
		int userId = (int) session.getAttribute("id");


		// User deleted and session invalidated. Put in a try-catch for security
		try {
			userService.deleteUser(userId); 
			session.invalidate();
			APIResponse resp = new APIResponse("Account deleted successfully");
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			APIResponse resp = new APIResponse("Unable to delete account");
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

}
