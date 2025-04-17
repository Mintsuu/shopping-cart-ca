package sg.edu.nus.team3.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.nus.team3.shoppingcart.model.ShoppingCart;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@ author @ thina 
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	// find shopping cart by user id
	// no need this method anymore i think
	// @Query("SELECT s FROM ShoppingCart s WHERE s.user.id = :userId")
	// Optional<ShoppingCart> findShoppingCartByUserId(@Param("userId") int id);

	// find shopping cart by shopping_cart id
	// session has shopping_cart id directly
	// method is find shoppingcart by shoppingcart id
	@Query("SELECT s FROM ShoppingCart s WHERE s.id = :cartId")
	Optional<ShoppingCart> findShoppingCartById(@Param("cartId") int cartId);

}
