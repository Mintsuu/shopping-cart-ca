package sg.edu.nus.team3.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcart_item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JsonIgnore
    private ShoppingCart shoppingCart;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;

    public ShoppingCartItem() {

    }

    public ShoppingCartItem(ShoppingCart shoppingCart, Product product, int quantity) {
        super();
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem [id=" + id + ", shoppingCart=" + shoppingCart + ", product=" + product + ", quantity="
                + quantity + "]";
    }

    /*
     * public void addItemToCart(ShoppingCart cart, Product product, int quantity) {
     * // TODO: Remove exceptions, don't do it here
     * if (cart == null || product == null) {
     * throw new IllegalArgumentException("购物车和商品不能为null");
     * }
     * if (quantity <= 0) {
     * throw new IllegalArgumentException("数量必须大于0");
     * }
     * this.shoppingCart = cart;
     * this.product = product;
     * }
     * 
     * public int getQuantity() {
     * return quantity;
     * }
     * 
     * public void setQuantity(int quantity) {
     * this.quantity = quantity;
     * }
     * 
     * /*
     * public void addItemToCart(ShoppingCart cart, Product product, int quantity) {
     * // TODO: Remove exceptions, don't do it here
     * if (cart == null || product == null) {
     * throw new IllegalArgumentException("购物车和商品不能为null");
     * }
     * if (quantity <= 0) {
     * throw new IllegalArgumentException("数量必须大于0");
     * }
     * this.shoppingCart = cart;
     * this.product = product;
     * this.quantity = quantity;
     * }
     * 
     * public ShoppingCartItem viewItem() {
     * return this;
     * }
     * 
     */

}
