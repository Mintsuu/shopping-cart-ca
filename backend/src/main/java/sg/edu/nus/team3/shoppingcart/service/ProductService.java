package sg.edu.nus.team3.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import sg.edu.nus.team3.shoppingcart.model.Product;

// @author Jared Chua
public interface ProductService {

  public List<Product> searchProductById(int product_id);

  public List<Product> getAllProducts();

  public void editProductById(int product_id, Product product);

  public void createProduct(Product product);

  public void deleteProductById(int product_id);

  public List<Product> searchProductByName(String product_name);


  // @author Shengyi
  public List<Product> getProductsByPriceRange(double min, double max);

  // addded by @ Thina
  public Product findProductById(int productId);

  // @author Dion Yao
  public List<Product> searchProducts(String input);
}
