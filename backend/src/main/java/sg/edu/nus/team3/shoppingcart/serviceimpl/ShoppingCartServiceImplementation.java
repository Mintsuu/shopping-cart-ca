package sg.edu.nus.team3.shoppingcart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartItemRepository;
import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartRepository;
import sg.edu.nus.team3.shoppingcart.service.ShoppingCartService;
import java.util.Optional;
import sg.edu.nus.team3.shoppingcart.service.ProductService;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;

// @ authored by @thina 

@Service
@Transactional
public class ShoppingCartServiceImplementation implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository scRepo;

	@Autowired
	ShoppingCartItemRepository scItemRepo;

	@Autowired
	ProductRepository productRepo;

	@Override
	@Transactional
	public ShoppingCart findShoppingCartById(int id) {

		Optional<ShoppingCart> userShoppingCart = scRepo.findShoppingCartById(id);
		if (!(userShoppingCart.isPresent())) {
			throw new RuntimeException("Shopping cart not found for user id: " + id);
		} else {
			return userShoppingCart.get();
		}

	}

	@Override
	@Transactional
	public void saveShoppingCart(ShoppingCart userShoppingCart) {
		// save cart to database
		ShoppingCart savedShoppingCart = scRepo.save(userShoppingCart);

	}

	@Override
	@Transactional
	public void deleteAllItemsInCart(int cartId) {

		// use find cart by id method in the earlier part of this service implementation
		ShoppingCart userCart = findShoppingCartById(cartId);

		List<ShoppingCartItem> listCartItems = userCart.getItems();

		// delete all items in the cart from the database
		for (int i = 0; i < listCartItems.size(); i++) {
			// get each shopping cart item id and delete from the database
			ShoppingCartItem cartItem = listCartItems.get(i);
			// after getting each shopping cart item, delete each item from the database of
			// shopping cart item
			int cartItemId = cartItem.getId();
			scItemRepo.deleteById(cartItemId);
		}

		// clear memory of the list after removing from database
		listCartItems.removeAll(listCartItems);

	}

	public ShoppingCart addItemToCart(int shoppingCartId, int productId, int quantity) {

		// check if cart exists before proceeding
		ShoppingCart userCart = findShoppingCartById(shoppingCartId);

		// check if the product id entered exists in the database
		// assign product to validProduct variable if the product exists
		Product validProduct;
		// use the product repository to find the product by id
		Optional<Product> product = productRepo.findProductById(productId);
		if (!(product.isPresent())) {
			throw new RuntimeException("Product not found for product id:" + productId);
		} else {
			// assign existing product to the validProduct variable to be used later in the
			// code
			validProduct = product.get();

		}

		// assuming that product and shoppingcart are valid after going through checks

		// then get the list of the items in cart
		// if the list contains the product, update quantity of the product in the cart
		// else, add the product to the cart and set the quantity
		List<ShoppingCartItem> listCartItems = userCart.getItems();

		// boolean condition to check if product match with cart items
		boolean productMatch = false;
		// loop through list of cart items to check if product entered matches cart
		// items
		// if yes, then save the new quantity of the cart item
		for (int i = 0; i < listCartItems.size(); i++) {
			ShoppingCartItem cartItem = listCartItems.get(i);
			Product productInCart = cartItem.getProduct();
			// if product already in cart, update quantity
			if (productInCart.getId() == productId) {
				int newQuantity = cartItem.getQuantity() + quantity;
				cartItem.setQuantity(newQuantity);
				//scItemRepo.save(cartItem);
				scRepo.save(userCart);
				productMatch = true;
				break;

			}
			; // end of if statement

		} // end of for loop that loops through the cart items to find a match

		// if there is no match with product and items in cart, then need to manually
		// add product into shopping cart
		if (productMatch == false) {
			ShoppingCartItem newCartItem = new ShoppingCartItem();
			newCartItem.setProduct(validProduct);
			newCartItem.setQuantity(quantity);
			newCartItem.setShoppingCart(userCart);
			//scItemRepo.save(newCartItem);
			userCart.getItems().add(newCartItem);
			scRepo.save(userCart);

		} // end of if statemnent for no product match

		return userCart;
	}// end of method addItemToCart

}
