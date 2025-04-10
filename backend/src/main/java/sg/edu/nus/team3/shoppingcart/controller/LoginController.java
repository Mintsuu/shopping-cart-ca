package sg.edu.nus.team3.shoppingcart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.service.UserService;

/**
@author diony
*/

@RestController
@CrossOrigin()
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "view";
	}

	
	@PostMapping("/login")
	public ResponseEntity<?> handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		
		// Log users in if email exists in database, and associated password matches
		// on successful login, updates session with "email" and "role" attributes
		
		if (userService.loginAttempt(email, password)) {
			session.setAttribute("id", userService.findUserByEmail(email).get().getId());
			session.setAttribute("role", userService.findUserByEmail(email).get().getRole());
			
			return ResponseEntity.ok(Map.of("message","Login successful"));
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "k")));
	}
	
	
	
	//public ResponseEntity<Map<String, Object>> checkLoginStatus(HttpSession session) {
		//Object id = session.
	//}
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		// Log users in if email exists in database, and associated password matches
		// on successful login, updates session with "email" and "role" attributes
		
		try {
			User newUser = userService.createUser(user);
			
			return new ResponseEntity<User> (newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		
	    // Deletes all information in current session, and locks users out of application till next login
		session.invalidate();
		
		
		return ResponseEntity.ok(Map.of("message", "Logged out"));
	}
	
	
	/*
	
	@PostMapping("/login")
	public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		
		// Log users in if email exists in database, and associated password matches
		// on successful login, updates session with "email" and "role" attributes
		
		if (userService.loginAttempt(email, password)) {
			session.setAttribute("id", userService.findUserByEmail(email).get().getId());
			session.setAttribute("role", userService.findUserByEmail(email).get().getRole());
			
			return "redirect:/";
		}
		
		return "login";
	}
	
	*/
}
