package sg.edu.nus.team3.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.edu.nus.team3.shoppingcart.model.Product;
import sg.edu.nus.team3.shoppingcart.service.ProductService;
import sg.edu.nus.team3.shoppingcart.util.APIResponse;

import java.util.List;

/**
 * @author Gao Shengyi, Dion Yao
 */

@RestController
@RequestMapping("/product")
public class BrowseController {


	@Autowired
	private ProductService productService;


	// @author Shengyi
	@GetMapping("/all")
	public ResponseEntity<?> browseAllProducts() {

		try {
			return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
		} catch (Exception e) {
			APIResponse resp = new APIResponse("No products found");
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}

	}


	// @author Dion Yao
	@GetMapping("/search")
	public ResponseEntity<?> searchProducts(@RequestParam String input) {

		try {
			return new ResponseEntity<>(productService.searchProducts(input), HttpStatus.OK);
		} catch (Exception e) {
			APIResponse resp = new APIResponse("No matching products found");
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}


	}

	// @author Dion Yao
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductDetail(@PathVariable int id) {

		try {
			Product product = productService.findProductById(id);
			return new ResponseEntity<>(product, HttpStatus.OK);

		} catch (Exception e) {
			APIResponse resp = new APIResponse("No matching product found");
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}
}


