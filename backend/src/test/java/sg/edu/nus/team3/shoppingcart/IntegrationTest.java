package sg.edu.nus.team3.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.OrderItem;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.repository.OrderItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.OrderRepository;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartRepository;
import sg.edu.nus.team3.shoppingcart.repository.UserRepository;

@SpringBootTest
public class IntegrationTest {
    @Autowired
    OrderItemRepository orderItemRepo;
    @Autowired
    OrderRepository orderRepo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    ShoppingCartItemRepository cartItemRepo;
    @Autowired
    ShoppingCartRepository cartRepo;
    @Autowired
    UserRepository userRepo;

    @Test
    @DisplayName("Should retrieve at least 1 entry in the user database")
    public void retrieveUserSample() {
        int userCount = userRepo.findAll().size();
        assertTrue(userCount > 0, "There should be at least 1 users in the database.");
    }

    @Test
    @DisplayName("Should retrieve at least 1 entry in the order database")
    public void retrieveOrderSample() {
        int orderCount = orderRepo.findAll().size();
        assertTrue(orderCount > 0, "There should be at least 1 order in the database.");
    }

    @Test
    @DisplayName("Should retrieve at least 1 entry in the product database")
    public void retrieveProductSample() {
        int productCount = productRepo.findAll().size();
        assertTrue(productCount > 0, "There should be at least 1 product in the database.");
    }

    @Test
    @DisplayName("Should retrieve at least 1 entry in the order items database")
    public void retrieveOrderItemSample() {
        int orderItemCount = orderItemRepo.findAll().size();
        assertTrue(orderItemCount > 0, "There should be at least 1 order items in the database.");
    }

    @Test
    @DisplayName("Should retrieve at least 1 entry in the cart item database")
    public void retrieveCartItemSample() {
        int cartItemCount = cartItemRepo.findAll().size();
        assertTrue(cartItemCount > 0, "There should be at least 1 cart items in the database.");
    }

    @Test
    @DisplayName("Should retrieve at least 1 entry in the carts database")
    public void retrieveCartSample() {
        int cartCount = cartRepo.findAll().size();
        assertTrue(cartCount > 0, "There should be at least 1 cart in the database.");
    }

    @Test
    @DisplayName("Should create new sample user along with any cascading entities")
    public void createNewUserTest() {

    }

    @Test
    @DisplayName("Should create new sample order along with any cascading entities")
    public void createNewOrderTest() {

    }

    @Test
    @DisplayName("Should create new sample product along with any cascading entities")
    public void createNewProductTest() {

    }

    @Test
    @DisplayName("Should create new sample order item along with any cascading entities")
    public void createNewOrderItemTest() {

    }

    @Test
    @DisplayName("All tables in the database can have rows added to it")
    public void addDataToTables() {
        int prevOrderItemCount = orderItemRepo.findAll().size();
        int prevOrderCount = orderRepo.findAll().size();
        int prevProductCount = productRepo.findAll().size();
        int prevCartItemCount = cartItemRepo.findAll().size();
        int prevCartCount = cartRepo.findAll().size();
        int prevUserCount = userRepo.findAll().size();

        User testUser = new User("alice.johnson@email.com", "hashed_pw_aj", "Alice", "Johnson", "91112233",
                "123 Oak Street, Anytown");
        // Order testOrder = new Order(testUser, LocalDateTime.of(2023, 10, 15, 14, 30,
        // 0), LocalDate.of(2023, 10, 15),
        // "Completed", "Credit Card", new ArrayList<OrderItem>());
        Product testProduct = new Product("Laptop", 21.3, 2, "Electronics");
        // OrderItem testOrderItem = new OrderItem(5, 2.1, testOrder, testProduct);

        userRepo.save(testUser);
        // orderRepo.save(testOrder);
        productRepo.save(testProduct);
        // orderItemRepo.save(testOrderItem);

        int afterOrderItemCount = orderItemRepo.findAll().size();
        int afterOrderCount = orderRepo.findAll().size();
        int afterProductCount = productRepo.findAll().size();
        int afterCartItemCount = cartItemRepo.findAll().size();
        int afterCartCount = cartRepo.findAll().size();
        int afterUserCount = userRepo.findAll().size();

        assertTrue(afterOrderItemCount > prevOrderItemCount, "There should be an additional row in the order table");
        assertTrue(afterOrderCount > prevOrderCount, "There should be an additional row in the order table");
        assertTrue(afterProductCount > prevProductCount, "There should be an additional row in the order table");
        assertTrue(afterCartItemCount > prevCartItemCount, "There should be an additional row in the order table");
        assertTrue(afterCartCount > prevCartCount, "There should be an additional row in the order table");
        assertTrue(afterUserCount > prevUserCount, "There should be an additional row in the order table");

    }
}
