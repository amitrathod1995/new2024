package com.edusol.products.controller;
import java.util.*;
import org.slf4j.*;
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
import com.edusol.products.model.Products;
import com.edusol.products.service.ProductsService;

@RestController
@RequestMapping("/products")

public class ProductsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired

	ProductsService productsService;

	@GetMapping("/get-products")
	public Object getProducts() {
	@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) productsService.getProducts();
		logger.info(products.toString());
		return (products);
	}
	@PostMapping("/add-products")
	public Object addProducts(@RequestBody Products products) {
	
		logger.info(products.toString());
		return productsService.addProducts(products);
	}

	@GetMapping("/get-products-by-id")
	public Object getProductsById(@RequestParam int id) {

		Object products = productsService.getProductsById(id);
		logger.info(products.toString());
		return  (products);

	}

	@GetMapping("/get-products-by-category")
	public Object getProductsByCategory(@RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) productsService.getProductsByCategory(category);
		logger.info(products.toString());
		
		return  (products);
	}

	@PutMapping("/update-products")
	public Object updateProducts(@RequestBody Products products) {
		//@SuppressWarnings("unchecked")
		//Products products = productsService.updateProducts(id);
		//logger.info(products.toString());
		logger.info("product Details:"+products.toString());
		return  productsService.updateProducts(products);
	}

	@DeleteMapping("/delete-products")
	public Object deleteProducts(@RequestParam int id) {
		
		logger.info("product id:"+id);
		return productsService.deleteProducts(id);
	}

	@GetMapping("/get-products-price")
	public Object getProductsPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
	List<Products> products = (List<Products>) productsService.getProductsPrice(price);
		logger.info(products.toString());
		
		return (products);
	}

	@GetMapping("/get-products-by-price-and-category")
	public Object getProdutsByPriceAndCategory(@RequestParam float price, @RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) productsService.getProductsByPriceAndCategory(price, category);
		logger.info(products.toString());
		
		return (products);
	}
	
	@GetMapping("/get-products-by-price-range")
	public Object getProductsPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max) {
			@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) productsService.getProductsPriceByRange(min,max);
		logger.info(products.toString());
		return (products);
	}
	

	@GetMapping("/get-products-by-price-rangeand-category")
	public Object getProductsPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max,@RequestParam String category) {
			@SuppressWarnings("unchecked")
		List<Products> products = (List<Products>) productsService.getProductsPriceByRangeAndCategory(min,max,category);
		logger.info(products.toString());
		return (products);
	}

}
