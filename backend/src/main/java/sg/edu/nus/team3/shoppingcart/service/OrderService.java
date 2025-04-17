package sg.edu.nus.team3.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.OrderItem;
import sg.edu.nus.team3.shoppingcart.projections.OrderProjection;

public interface OrderService {

	public Optional<Order> getOptOrderById(int order_id);

	public List<Order> getAllOrders();

	public List<OrderProjection> getWeeklyOrders();

	
	public Order checkoutCart(int userId, int cartId, String paymentMethod);
	public Order getOrderById(int id);
	

}
