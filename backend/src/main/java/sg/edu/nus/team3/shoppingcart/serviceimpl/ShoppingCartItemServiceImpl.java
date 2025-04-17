package sg.edu.nus.team3.shoppingcart.serviceimpl;

import jakarta.transaction.Transactional;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;
import sg.edu.nus.team3.shoppingcart.service.ShoppingCartItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.team3.shoppingcart.repository.ShoppingCartItemRepository;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;

	@Override
	public void updateShoppingCartItemQuantity() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteShoppingCartItem() {
		// TODO Auto-generated method stub
	}

	// authored by @thina
	@Override
	@Transactional
	public ShoppingCartItem createShoppingCartItem(ShoppingCart userShoppingCart, Product product,
			int quantity) {
		// create new shopping cart item
		ShoppingCartItem converted_ShoppingCartItem = new ShoppingCartItem(userShoppingCart,
				product, quantity);

		// save this new shopping cart item to the database
		shoppingCartItemRepository.save(converted_ShoppingCartItem);
		// return the new shopping cart item
		return converted_ShoppingCartItem;

	}

}
