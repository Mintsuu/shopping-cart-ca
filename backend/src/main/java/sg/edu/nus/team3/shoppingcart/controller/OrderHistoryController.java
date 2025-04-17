package sg.edu.nus.team3.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.service.OrderService;
import sg.edu.nus.team3.shoppingcart.service.UserService;
import sg.edu.nus.team3.shoppingcart.util.APIResponse;

/**
 * @author Ma Li, Dion Yao
 */

@RestController
@RequestMapping("/order")
public class OrderHistoryController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;

	// Authored by Ma Li
	@GetMapping("/history")
	@ResponseBody
	public ResponseEntity<?> getOrderHistory(HttpSession session) {

		int userId = (int) session.getAttribute("id");

		User user = userService.findUserById(userId);
		List<Order> orders = user.getOrders();

		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	// Authored by Dion Yao
	@GetMapping("/history/{id}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int id, HttpSession session) {
	    int userId = (int) session.getAttribute("id");
	    String role = (String) session.getAttribute("role");

	    Order order = orderService.getOrderById(id);

	    // Booleans to check if staff, or if logged in customer is viewing an order they "own"
	    boolean isStaff = role != null && role.equalsIgnoreCase("staff");
	    boolean isOwner = (order.getUser().getId() == userId);
	    
	    // Allow only staff or order owner to view order details
	    if ((isStaff == false) && (isOwner == false)) {
			APIResponse resp = new APIResponse("You are not allowed to view this page");
	        return new ResponseEntity<>(resp, HttpStatus.FORBIDDEN);
	    }

	    return new ResponseEntity<>(order, HttpStatus.OK);
	}
}
