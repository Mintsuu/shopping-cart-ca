package sg.edu.nus.team3.shoppingcart.service;

import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;

public interface ShoppingCartItemService {

	public void updateShoppingCartItemQuantity();

	public void deleteShoppingCartItem();

	// please do not delete
	// authored by @thina, method to convert product to shopping cart item and save
	// into database to be
	// used in the shoppingcart controller to add product to shopping cart
	public ShoppingCartItem createShoppingCartItem(ShoppingCart shoppingCart, Product product, int quantity);

}
