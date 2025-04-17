package sg.edu.nus.team3.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"order"})		//Ignore "order" during serialization (i.e. prevent loops in json)
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @Column(name = "transacted_unit_price")
    private double unitPrice;

    @ManyToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem() {

    }
    
    

    public OrderItem(int quantity, double unitPrice, Order order, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.order = order;
		this.product = product;
	}
    
    public OrderItem(ShoppingCartItem cartItem, Order order) {
		super();
		this.quantity = cartItem.getQuantity();
		this.unitPrice = cartItem.getProduct().getUnitPrice();
		this.order = order;
		this.product = cartItem.getProduct();
	}
    
    // USE THIS IN CHECKOUT IMPLEMENTATION
    public OrderItem(ShoppingCartItem cartItem) {
		super();
		this.quantity = cartItem.getQuantity();
		this.unitPrice = cartItem.getProduct().getUnitPrice();
		this.product = cartItem.getProduct();
	}



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", order=" + order
				+ ", product=" + product + "]";
	}
    
    
    

}
