package sg.edu.nus.team3.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.model.OrderItem;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.repository.OrderItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.OrderRepository;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;
import sg.edu.nus.team3.shoppingcart.serviceimpl.OrderServiceImpl;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    // @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    // @Test
    // public Order createOrder(List<OrderItem> orderItems) {

    // Order order = new Order();
    // User user = new User();

    // int productId;

    // // Optional<Order> order = orderRepository.findById(orderId);

    // // Create test products
    // // Hardcode products
    // Product product1 = new Product();
    // product1.setId(1);
    // product1.setName("Milk");
    // product1.setUnitPrice(2.99);
    // product1.setStock(10);
    // product1.setCategory("Dairy");

    // Product product2 = new Product();
    // product2.setId(2);
    // product2.setName("Cheese");
    // product2.setUnitPrice(4.99);
    // product2.setStock(10);
    // product2.setCategory("Dairy");

    // Product product3 = new Product();
    // product3.setId(3);
    // product3.setName("Tomato");
    // product3.setUnitPrice(1.99);
    // product3.setStock(20);
    // product3.setCategory("Vegetable");

    // // Create a List
    // List<Product> products = new ArrayList<>();
    // products.add(product1);
    // products.add(product2);
    // products.add(product3);

    // // Create test orderItems
    // // Hardcode orderItems
    // OrderItem orderItem1 = new OrderItem();
    // OrderItem orderItem2 = new OrderItem();
    // OrderItem orderItem3 = new OrderItem();

    // orderItem1.setId(1);
    // orderItem1.setQuantity(5);
    // orderItem1.setUnitPrice(product1.getUnitPrice());
    // orderItem1.setProduct(product1);
    // orderItem1.setOrder(order);

    // orderItem2.setId(2);
    // orderItem2.setQuantity(1);
    // orderItem2.setUnitPrice(product2.getUnitPrice());
    // orderItem2.setProduct(product2);
    // orderItem2.setOrder(order);

    // orderItem3.setId(3);
    // orderItem3.setQuantity(2);
    // orderItem3.setUnitPrice(product3.getUnitPrice());
    // orderItem3.setProduct(product3);
    // orderItem3.setOrder(order);

    // // Create a List
    // // List<OrderItem> orderItems = new ArrayList<>();
    // orderItems.add(orderItem1);
    // orderItems.add(orderItem2);
    // orderItems.add(orderItem3);

    // // Create Order from OrderItems
    // order.setId(1);
    // order.setUser(user);
    // order.setCreateAt(LocalDateTime.of(2025, 4, 7, 15, 30, 0));
    // order.setFulfilmentDate(LocalDate.of(2025, 4, 7));
    // order.setStatus("ok");
    // order.setPaymentMethod("card");
    // order.setOrderItem(orderItems);

    // // remove items from products
    // for (OrderItem orderItem : orderItems) {
    // productId = orderItems.getProduct().getId;
    // Optional<Product> product = productRepository.findById(productId);

    // assert product != null && !product.isEmpty() : "Product should be in the
    // list";

    // assert product.getStock() > 0 : "Stock must be greater than zero. Actual: " +
    // product.getStock();
    // assert product.getStock() >= orderItems.getQuantity()
    // : "Product stock must be greater than or equal to order quantity. Actual
    // difference: "
    // + (product.getStock() - order.getQuantity());

    // /*
    // * if ((product.getStock() - orderItems.getQuantity())<0) {
    // *
    // * }
    // */
    // product.setStock(product.getStock() - orderItems.getQuantity());
    // }

    // }

}
