package com.edusol.Productss.controller;
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
import com.edusol.productss.model.Productss;
import com.edusol.productss.service.ProductssService;

@RestController
@RequestMapping("/product")
public class ProductssController {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired

	ProductssService productssService;

	@GetMapping("/get-products")
	public Object getProducts() {
	@SuppressWarnings("unchecked")
		List<Productss> productss = (List<Productss>) productssService.getProducts();
		logger.info(productss.toString());
		return (productss);
	}
	@PostMapping("/add-product")
	public Object addProduct(@RequestBody Productss productss) {

		logger.info(productss.toString());
		return productssService.addProduct(productss);
	}

	@GetMapping("/get-product-by-id")
	public Object getProductById(@RequestParam int id) {

		Object product = productssService.getProductById(id);
		logger.info(productss.toString());
		return  (productss);

	}

	@GetMapping("/get-product-by-category")
	public Object getProductByCategory(@RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Productss> productss = (List<Productss>) productssService.getProductByCategory(category);
		logger.info(productss.toString());
		
		return  (productss);
	}

	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody Productss productss) {
		//@SuppressWarnings("unchecked")
		//Products products = productsService.updateProducts(id);
		//logger.info(products.toString());
		logger.info("product Details:"+productss.toString());
		return  productssService.updateProduct(productss);
	}

	@DeleteMapping("/delete-product")
	public Object deleteProduct(@RequestParam int id) {
		
		logger.info("product id:"+id);
		return productssService.deleteProduct(id);
	}

	@GetMapping("/get-product-price")
	public Object getProductPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
	List<Productss> productss = (List<Productss>) productssService.getProductPrice(price);
		logger.info(productss.toString());
		
		return (productss);
	}

	@GetMapping("/get-product-by-price-and-category")
	public Object getProdutByPriceAndCategory(@RequestParam float price, @RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Productss> productss = (List<Productss>) productssService.getProductByPriceAndCategory(price, category);
		logger.info(productss.toString());
		
		return (productss);
	}
	
	@GetMapping("/get-product-by-price-range")
	public Object getProductPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max) {
			@SuppressWarnings("unchecked")
		List<Productss> productss = (List<Productss>) productssService.getProductPriceByRange(min,max);
		logger.info(productss.toString());
		return (productss);
	}
	

	@GetMapping("/get-product-by-price-rangeand-category")
	public Object getProductsPriceByRangeAndCategory(@RequestParam float min,@RequestParam float max,@RequestParam String category) {
			@SuppressWarnings("unchecked")
		List<Productss> productss = (List<Productss>) productssService.getProductPriceByRangeAndCategory(min,max,category);
		logger.info(productss.toString());
		return (productss);
	}


}
