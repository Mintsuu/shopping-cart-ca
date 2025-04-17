package sg.edu.nus.team3.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import sg.edu.nus.team3.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p")
    public Optional<List<Product>> retrieveProductListFromProduct();

    @Query("SELECT p FROM Product p WHERE p.name = :productName")
    public Optional<Product> findByProductName(@Param("productName") String product_name);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :name, p.stock = :stock, p.unitPrice = :unit_price, p.category = :category WHERE p.id = :productId")
    public void updateProductById(@Param("productId") int product_id, @Param("name") String name,
            @Param("stock") int stock,
            @Param("unit_price") double unit_price, @Param("category") String category);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id = :productId")
    public void deleteProductById(@Param("productId") int product_id);
    
    
    // authored by @ Thina to be used in ShoppingCartService method as I need to
    // find the product by productId
    // for the add to cart case
    // please do not delete this

    @Transactional
    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    public Optional<Product> findProductById(@Param("productId") int productId);
    
    // @author Shengyi
    @Query("SELECT p FROM Product p WHERE p.unitPrice BETWEEN :min AND :max")
    public List<Product> findByPriceBetween(Double min, Double max);
    
    // @author Dion
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%'))")
    public List<Product> findByNameIgnoreCase(@Param("search")String input);
}
