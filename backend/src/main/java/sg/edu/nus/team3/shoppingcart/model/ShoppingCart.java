package sg.edu.nus.team3.shoppingcart.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(mappedBy = "shoppingCart")
	private User user;

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	// shopping cart items has the foreign key of shopping cart id
	private List<ShoppingCartItem> items;

	private LocalDateTime updatedAt;

	public ShoppingCart() {

	}

	public ShoppingCart(User user) {
		this.user = user;
		this.updatedAt = LocalDateTime.of(2023, 10, 15, 14, 30, 0);
		this.items = new ArrayList<ShoppingCartItem>();
	}

	public ShoppingCart(int id, User user, List<ShoppingCartItem> items, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.items = items;
		this.updatedAt = updatedAt;
	}

	public ShoppingCart(User user, List<ShoppingCartItem> items, LocalDateTime updatedAt) {
		super();
		this.user = user;
		this.items = items;
		this.updatedAt = updatedAt;
	}

	// getters and setters for shopping cart items

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

	public LocalDateTime getUpatedAt() {
		return updatedAt;
	}

	public void setUpatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", updatedAt=" + updatedAt + "]";
	}

}
