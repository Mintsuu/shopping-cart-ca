package sg.edu.nus.team3.shoppingcart.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.OrderItem;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;
import sg.edu.nus.team3.shoppingcart.model.User;

import sg.edu.nus.team3.shoppingcart.repository.UserRepository;
import sg.edu.nus.team3.shoppingcart.repository.OrderRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartRepository;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;

import sg.edu.nus.team3.shoppingcart.service.OrderService;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	// Create order and orderItems from shopping cart
	@Override
	public Order checkoutCart(int userId, int cartId) {
		User user = userRepository.findById(userId).orElseThrow();
		ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow();
		
		// Check to make sure the cart is not empty
		if (cart.getItems().isEmpty()) {
			throw new IllegalStateException("Cart is empty");
		}
		
		// Create new order
		Order order = new Order();
		order.setUser(user);
		order.setCreateAt(LocalDateTime.now());
		order.setStatus("PENDING");
		
		// Create orderItems and get the total price
		// Loop through shopping cart items and add each orderItem to order
		double total = 0.0;
		for (ShoppingCartItem item : cart.getItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setUnitPrice(item.getProduct().getUnitPrice());
			
			total += orderItem.getUnitPrice()*orderItem.getQuantity();
			order.getOrderItems().add(orderItem);
		}
		
		// Set the total price and save order to order repository
		order.setTotalAmount(total);
		orderRepository.save(order);
		
		// Clear cart at the end
		cart.getItems().clear();
		shoppingCartRepository.save(cart);
		
		return order;
		
	}
	

	@Override
	public List<Order> findAllOrder() {
		return orderRepository.findAll();
	}
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	//Get the current order
	@Override
	public Order getOrderById(int id) {
		Order orderToCheck = orderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Order not found"));
		return orderToCheck;
	}
	
	
	@Override
	public void updateProductStock(Order order) {
		//Iterate through OrderItem list
		for (OrderItem item : order.getOrderItems()) {
			
			//Fetch the product by ID
			Product checkProduct = productRepository.findById(item.getProduct().getId())
					.orElseThrow(() -> new RuntimeException("Produt not found: " + item.getProduct().getId()));
			
			//Check to make sure we have the product
			if (checkProduct.getStock() < item.getQuantity()) {
				throw new RuntimeException("Not enough stock: " + checkProduct.getId());
			}
			
			//Remove from product if there's enough stock
			checkProduct.setStock(checkProduct.getStock() - item.getQuantity());
			
			//Save updated product
			productRepository.save(checkProduct);
		}
	}
	
	/*
	@Override
	public Order completeOrder(Order order) {
		order.setStatus("COMPLETED");
		
		LocalDateTime now = LocalDateTime.now();
		order.setFulfilmentDate(now);
		
		return orderRepository.save(order);
		//return order;
	}
	*/

	/*
	@Override
	public double calcTotal(List<OrderItem> orderItems) {
		
		double totalPrice = 0.0;
		
		//Iterate through OrderItem list
		for (OrderItem item: orderItems) {
			
			//Fetch the product by ID
			Product checkProduct = productRepository.findById(item.getProduct().getId())
					.orElseThrow(() -> new RuntimeException("Product not found: " + item.getProduct().getId()));
			
			totalPrice += checkProduct.getUnitPrice()*item.getQuantity();
			
		}
		return totalPrice;
	}
	*/
	
	
	

	
	
	//List all orders by user?
	//@Override
	//public List<Order> searchOrderHistory(User user) {
	//	return orderRepository.findByUser(user);
	//}
	
	//List orders made (by all users?) in the past week?
	//@Override
	//public List<Order>  getOrdersInWeek(Order order) {
	//


}
