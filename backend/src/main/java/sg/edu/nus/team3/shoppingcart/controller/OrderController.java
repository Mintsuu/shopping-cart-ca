package sg.edu.nus.team3.shoppingcart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.service.OrderService;
import sg.edu.nus.team3.shoppingcart.util.APIResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	//----------------------------------------------------------
	// Author: Hiroyo
	//----------------------------------------------------------
	
	@Autowired
	private OrderService orderService;
	
	// Create order, ask for payment method, "pay", complete order
	@PostMapping("/checkout")
	public ResponseEntity<?> checkoutCartAndSaveOrder(HttpSession session, @RequestParam String paymentMethod) {
		
		int userId = (int) session.getAttribute("id");
		int cartId = (int) session.getAttribute("cartId");
		
		
		try {
			// Create order from userId and cartId and paymentMethod
			Order order = orderService.checkoutCart(userId, cartId, paymentMethod);
			
			return new ResponseEntity<>(order,HttpStatus.OK);
			
		} catch (Exception e) {
			APIResponse resp = new APIResponse("Checkout failed");
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}

	}
	
	// Display order confirmation
	@GetMapping("/confirmation")
	public ResponseEntity<?> getOrderConfirmation(@RequestParam int orderId, HttpSession session) {
		int userId = (int) session.getAttribute("id");
		// Make sure the user is logged in
		
		Order order = orderService.getOrderById(orderId);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	//----------------------------------------------------------
	
	
	

}
