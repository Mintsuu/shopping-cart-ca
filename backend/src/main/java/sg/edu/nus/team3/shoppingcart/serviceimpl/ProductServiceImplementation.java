package sg.edu.nus.team3.shoppingcart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.repository.ProductRepository;
import sg.edu.nus.team3.shoppingcart.service.ProductService;

// @author Jared Chua
@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

  @Autowired
  public ProductRepository productRepo;

  @Override
  public List<Product> searchProductById(int product_id) {
    List<Product> productInfo = productRepo.findById(product_id).stream().toList();
    return productInfo;
  }

  // @author of this method : Thina
  // this method is used to find the product by productId for the add to cart case
  @Override
  public Product findProductById(int productId) {
    return productRepo.findProductById(productId).orElseThrow();
  }

  @Override
  public List<Product> getAllProducts() {
    List<Product> productList = productRepo.retrieveProductListFromProduct().get();
    return productList;
  }

  @Override
  public void createProduct(Product product) {
    productRepo.save(product);
  }

  @Override
  public void editProductById(int product_id, Product product) {
    productRepo.updateProductById(product_id, product.getName(), product.getStock(), product.getUnitPrice(),
        product.getCategory());
  }
  
  @Override
  public void deleteProductById(int product_id) {
    productRepo.deleteProductById(product_id);
  }
  
  @Override
  public List<Product> searchProductByName(String product_name) {
    List<Product> productInfo = productRepo.findByProductName(product_name).stream().toList();
    return productInfo;
  }
  
  // @author Shengyi
  @Override
  public List<Product> getProductsByPriceRange(double min,double max) {
	    if (min < 0 || max > 0) {
	      throw new IllegalArgumentException("The price can't be less than zero!");
	    }
	    if (min > max) {
	      throw new IllegalArgumentException("The price can't be greater than zero!");
	    }
	    return productRepo.findByPriceBetween(min, max);
	  }
  
  // @author Dion Yao
  @Override
  public List<Product> searchProducts(String input) {
	  return productRepo.findByNameIgnoreCase(input);
  }
}
