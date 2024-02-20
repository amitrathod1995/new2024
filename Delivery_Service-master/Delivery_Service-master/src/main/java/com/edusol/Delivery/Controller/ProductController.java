package com.edusol.Delivery.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.Delivery.Service.ProductService;
import com.edusol.Delivery.module.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired

	ProductService productService;

	@GetMapping("/get-products")
	public Object getProducts() {
	@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProducts();
		logger.info(product.toString());
		return (product);
	}
	@PostMapping("/add-product")
	public Object addProduct(@RequestBody Product product) {

		logger.info(product.toString());
		return productService.addProduct(product);
	}

	@GetMapping("/get-product-by-id")
	public Object getProductById(@RequestParam int id) {

		Object product = productService.getProductById(id);
		logger.info(product.toString());
		return  (product);

	}

	@GetMapping("/get-product-by-category")
	public Object getProductByCategory(@RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductByCategory(category);
		logger.info(product.toString());
		
		return  (product);
	}

	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody Product product) {
		//@SuppressWarnings("unchecked")
		//Products products = productsService.updateProducts(id);
		//logger.info(products.toString());
		logger.info("product Details:"+product.toString());
		return  productService.updateProduct(product);
	}

	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id) {
		
		logger.info("product id:"+id);
		return productService.deleteProduct(id);
	}

	@GetMapping("/get-product-price")
	public Object getProductPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
	List<Product> product = (List<Product>) productService.getProductPrice(price);
		logger.info(product.toString());
		
		return (product);
	}

	@GetMapping("/get-product-by-price-and-category")
	public Object getProdutByPriceAndCategory(@RequestParam float price, @RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductByPriceAndCategory(price, category);
		logger.info(product.toString());
		
		return (product);
	}
	
	@GetMapping("/get-product-by-price-range")
	public Object getProductPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max) {
			@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPriceByRange(min,max);
		logger.info(product.toString());
		return (product);
	}
	

	@GetMapping("/get-product-by-price-rangeand-category")
	public Object getProductsPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max,@RequestParam String category) {
			@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) productService.getProductPriceByRangeAndCategory(min,max,category);
		logger.info(product.toString());
		return (product);
	}

	//=============================================================================
	@GetMapping("/get-product-by-cuctomer-id")
	public Object getProductbyCustomerid(@RequestParam int id){
		return productService.getProductbyCustomerid(id);	
}
}
