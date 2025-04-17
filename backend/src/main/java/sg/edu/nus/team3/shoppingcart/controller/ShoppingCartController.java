package sg.edu.nus.team3.shoppingcart.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCartItem;
import sg.edu.nus.team3.shoppingcart.service.ProductService;
import sg.edu.nus.team3.shoppingcart.service.ShoppingCartItemService;
import sg.edu.nus.team3.shoppingcart.service.ShoppingCartService;

// @Authored by @thina
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart_service;

    @Autowired
    private ShoppingCartItemService shoppingCartItem_service;

    @Autowired
    private ProductService product_service;

    @GetMapping("/items")
    public ResponseEntity<List<ShoppingCartItem>> getItemsInCart(HttpSession session) {
        int shoppingCartId = (int) session.getAttribute("cartId");
        List<ShoppingCartItem> list_items = shoppingCart_service.findShoppingCartById(shoppingCartId).getItems();
        return new ResponseEntity<List<ShoppingCartItem>>(list_items, HttpStatus.OK);
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<List<ShoppingCartItem>> addItemToCart(@PathVariable("productId") int productId,
            @RequestParam("quantity") int quantity,
            HttpSession session) {
        // get shopping cart id, product id, and quantity before can use addItemToCart
        int cartId = (int) session.getAttribute("cartId");

        // once cart and product are confirmed to exist, call method to add product to
        // cart

        ShoppingCart userCart = shoppingCart_service.addItemToCart(cartId, productId, quantity);
        // method returns a shopping cart

        // from the cart item can get the list of items in shopping cart
        List<ShoppingCartItem> listCartItems = userCart.getItems();
        // return the list of items in the shopping cart

        // return the list of shopping cart items with the new item added to the cart
        return new ResponseEntity<List<ShoppingCartItem>>(listCartItems, HttpStatus.OK);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearShoppingCart(HttpSession session) {

        // user id from session object
        int cartId = (int) session.getAttribute("cartId");

        // call method from service class to delete all items in cart
        shoppingCart_service.deleteAllItemsInCart(cartId);

        // the following code has been implemented into the service method
        // deleteAllItemsInCart
        // // find shopping cart by user id
        // ShoppingCart user_shopping_cart =
        // shoppingCart_service.findShoppingCartByUserId(userid_session);
        // // get list of shopping cart items
        // List<ShoppingCartItem> shoppingcart_items = user_shopping_cart.getItems();

        // // delete all items in the cart from the database
        // for (int i = 0; i < shoppingcart_items.size(); i++) {
        // // get each shopping cart item id and delete from the database
        // ShoppingCartItem shoppingcart_item = shoppingcart_items.get(i);
        // // after getting each shopping cart item, delete each item from the database
        // of
        // // shopping cart item
        // int shopping_cart_item_id = shoppingcart_item.getId();
        // sc_itemrepo.deleteById(shopping_cart_item_id);
        // }

        // clear memory of the list after removing from database
        // shoppingcart_items.removeAll(shoppingcart_items);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
