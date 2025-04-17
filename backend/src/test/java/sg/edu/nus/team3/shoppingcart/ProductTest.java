package sg.edu.nus.team3.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.serviceimpl.ProductServiceImplementation;

// @author Jared Chua
@SpringBootTest(classes = ShoppingcartApplication.class)
public class ProductTest {
  @Autowired
  private ProductServiceImplementation productServiceImpl;

  // * Tests for getAllProducts
  @Test
  @DisplayName("Should return a list of products")
  public void getAllProductsTest() {
    List<Product> productList = productServiceImpl.getAllProducts();
    int entryCount = productList.size();
    // Test for multiple entry retrievals
    assertTrue(entryCount > 0, "There should be at least 1 product returned.");
  }

  // * Tests for searchProductById
  @Test
  @DisplayName("Should return a list of 1 product through searching of the product id")
  public void getOneProductById() {
    List<Product> getProduct = productServiceImpl.searchProductById(1);
    int entryCount = getProduct.size();

    // Test for correct search index
    assertTrue(getProduct.get(0).getName().equalsIgnoreCase("Laptop Pro X1"),
        "The product 'Laptop Pro X1' should've been returned, received: " + getProduct.get(0).getName());
    // Test for singular entry retrieval
    assertTrue(entryCount == 1, "Only 1 entry should've been returned.");
  }

  // * Tests for searchProductByName
  @Test
  @DisplayName("Should return a list of 1 product through searching of the product name")
  public void getOneProductByName() {
    String productNameToSearch = "Laptop Pro X1";
    List<Product> getProductByName = productServiceImpl.searchProductByName(productNameToSearch);
    int entryCount = getProductByName.size();

    // Test for correct search index
    assertTrue(getProductByName.get(0).getName().equalsIgnoreCase(productNameToSearch),
        "The product " + productNameToSearch + " should've been returned, received: "
            + getProductByName.get(0).getName());
    // Test for singular entry retrieval
    assertTrue(entryCount == 1, "Only 1 entry should've been returned.");
  }

  // * Tests for createProduct
  @Test
  @DisplayName("Should create a new product, with auto generated ID")
  public void createNewProduct() {
    Product createdProduct = new Product("TestProduct", 999.99, 888, "Vegetables");
    productServiceImpl.createProduct(createdProduct);
    List<Product> getProductByName = productServiceImpl.searchProductByName("TestProduct");
    int getTestProductId = productServiceImpl.searchProductByName(createdProduct.getName()).get(0).getId();
    // Test for newly created product
    assertTrue(getProductByName.get(0).getName().equalsIgnoreCase("TestProduct"),
        "The 'TestProduct' should've been returned.");
    productServiceImpl.deleteProductById(getTestProductId);
  }

  // * Tests for editProductById
  @Test
  @DisplayName("Should edit an existing product based on their ID")
  public void updateProductById() {
    Product createdProduct = new Product("TestProduct", 999.99, 888, "Vegetables");
    productServiceImpl.createProduct(createdProduct);
    Product productToBeEdited = new Product("TestEditProduct", 2999.99, 2999, "Test");
    int getTestProductId = productServiceImpl.searchProductByName(createdProduct.getName()).get(0).getId();
    productServiceImpl.editProductById(getTestProductId, productToBeEdited);

    List<Product> getEditedProduct = productServiceImpl.searchProductById(getTestProductId);
    assertTrue(getEditedProduct.get(0).getName().equalsIgnoreCase(productToBeEdited.getName()),
        "The product was not updated with all the provided data.");
    productServiceImpl.deleteProductById(getTestProductId);

  }

  // * Tests for deleteProductById
  @Test
  @DisplayName("Should delete an existing product based on their ID")
  public void deleteProduct() {
    Product createdProduct = new Product("TestProduct", 999.99, 888, "Vegetables");
    productServiceImpl.createProduct(createdProduct);
    int getTestProductId = productServiceImpl.searchProductByName(createdProduct.getName()).get(0).getId();
    List<Product> beforeDelete = productServiceImpl.searchProductById(getTestProductId);
    productServiceImpl.deleteProductById(getTestProductId);
    List<Product> getDeletedProduct = productServiceImpl.searchProductById(getTestProductId);
    assertTrue(!beforeDelete.equals(getDeletedProduct), "The product was not deleted successfully.");
  }
}
