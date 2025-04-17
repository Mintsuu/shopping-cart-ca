package sg.edu.nus.team3.shoppingcart;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.OrderItem;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.repository.OrderItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.OrderRepository;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartRepository;
import sg.edu.nus.team3.shoppingcart.repository.UserRepository;
import sg.edu.nus.team3.shoppingcart.service.UserService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runMe(UserService uSc) {
	// return args -> {
	// User jimmy = new User("testy.johnson@email.com", "91112233", "123 Oak Street,
	// Anytown", "Testy", "Johnson",
	// "password123");
	// uSc.registerUser(jimmy);
	// };
	// }

	// @Bean
	// CommandLineRunner runMe(UserRepository userRepo, OrderRepository orderRepo,
	// ProductRepository productRepo,
	// ShoppingCartRepository cartRepo, ShoppingCartItemRepository cartItemRepo,
	// OrderItemRepository orderItemRepo) {
	//
	// return args -> {
	//
	// System.out.println("--- Test persist each entity ---");
	//
	// User jimmy = new User("jimmy.johnson@email.com", "91112233", "123 Oak Street,
	// Anytown", "Alice", "Johnson",
	// "hashed_pw_aj");
	// ShoppingCart cart1 = jimmy.getShoppingCart();
	// Product product2 = new Product("NINTENDO", 21.3, 2, "Electronics");
	// productRepo.save(product2);
	// Order orderJimmy = new Order(jimmy, LocalDateTime.of(2023, 10, 15, 14, 30,
	// 0), LocalDate.of(2023, 10, 15),
	// "Completed", "Credit Card");
	// ShoppingCartItem cartItem = new ShoppingCartItem(jimmy.getShoppingCart(),
	// product2, 4);
	// OrderItem orderItem = new OrderItem(cartItem);
	// orderItem.setOrder(orderJimmy);
	//
	// userRepo.save(jimmy);
	// cartRepo.save(cart1);
	// orderRepo.save(orderJimmy);
	// productRepo.save(product2);
	// cartItemRepo.save(cartItem);
	// orderItemRepo.save(orderItem);
	//
	// System.out.println("--- Test retrieve each entity ---");
	//
	// List<User> users = userRepo.findAll();
	// users.forEach(user -> System.out.println(user));
	//
	// List<ShoppingCart> carts = cartRepo.findAll();
	// carts.forEach(cart -> System.out.println(cart));
	//
	// List<Order> orders1 = orderRepo.findAll();
	// orders1.forEach(order1 -> System.out.println(order1));
	//
	// List<Product> products = productRepo.findAll();
	// products.forEach(product -> System.out.println(product));
	//
	// List<OrderItem> ordersItems = orderItemRepo.findAll();
	// ordersItems.forEach(ordersItem -> System.out.println(ordersItem));
	//
	// List<ShoppingCartItem> cartItems = cartItemRepo.findAll();
	// cartItems.forEach(cartitem -> System.out.println(cartitem));
	//
	// };
	// }
}
