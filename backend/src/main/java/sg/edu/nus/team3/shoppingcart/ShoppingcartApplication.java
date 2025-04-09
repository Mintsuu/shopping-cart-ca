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

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}

	@Bean
	CommandLineRunner runMe(UserRepository userRepo, OrderRepository orderRepo, ProductRepository productRepo,
			ShoppingCartRepository cartRepo, ShoppingCartItemRepository cartItemRepo,
			OrderItemRepository orderItemRepo) {

		return args -> {

			System.out.println("--- Test persist each entity ---");

			User alice = new User("alice.johnson@email.com", "91112233", "123 Oak Street, Anytown", "Alice", "Johnson",
					"hashed_pw_aj");
			Order order = new Order(alice, LocalDateTime.of(2023, 10, 15, 14, 30, 0), LocalDate.of(2023, 10, 15),
					"Completed", "Credit Card", new ArrayList<OrderItem>());
			Product product1 = new Product("Laptop", 21.3, 2, "Electronics");
			OrderItem orderItem = new OrderItem(5, 2.1, order, product1);

			// userRepo.save(alice);
			// orderRepo.save(order);
			// productRepo.save(product1);
			// orderItemRepo.save(orderItem);

			System.out.println("--- Test retrieve each entity ---");
			if (userRepo.findAll().size() > 0 && orderRepo.findAll().size() > 0 && productRepo.findAll().size() > 0
					&& cartRepo.findAll().size() > 0
					&& cartItemRepo.findAll().size() > 0 && orderItemRepo.findAll().size() > 0)
				System.out.println("--- Database is properly synced. ---");
			else
				System.out.println("One or more tables have missing data. Please check your database.");
		};
	}
}
