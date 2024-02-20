package com.edusol.Delivery.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.edusol.Delivery.Repository.ProductRepository;
import com.edusol.Delivery.module.Product;
import com.google.gson.JsonObject;

@Service
public class ProductService {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository productRepository;
	
public Object getProducts() {
		
		return productRepository.findAll();
	}


public Object addProduct(Product product) {
	logger.info(product.toString());
	productRepository.save(product);
  logger.info("product added Successfully");
	return new ResponseEntity<>("Product added Successfully",HttpStatus.CREATED);
}
public Object getProductById(int id) {
	
	return productRepository.findById(id);

}

public Object getProductByCategory(String category) {
	
	return productRepository.findByCategory(category);

}

public Object updateProduct(Product product) {
	
	JsonObject response =new JsonObject();
	System.out.println("Request products:" + product);
	int id = product.getId();
    try {
	Product prod = productRepository.getOne(id);
	System.out.println("Request product :" + prod);

	System.out.println("old product:" + prod);
	prod.setPrice(product.getPrice());
	prod.setName(product.getName());
	prod.setCategory(product.getCategory());
	System.out.println("New product:" + prod);
	productRepository.save(prod);
    }
    catch(Exception e) {
    	logger.error(e.getMessage());
    	response.addProperty("statusCode", 404);
    	response.addProperty("statusMessage", e.getMessage());
    	return new ResponseEntity<>(response.toString(),HttpStatus.NOT_FOUND);
    }
    
    logger.info("Product Updated Successfully");
	return new ResponseEntity<>("Product Updated Successfully",HttpStatus.OK);
     	}


public Object deleteProduct(int id) {
	try {
		
	productRepository.deleteById(id);
	}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
    logger.info("product deleted Successfully");
    return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
}

public Object getProductPrice(float price) {
	//try {
		productRepository.findByPrice(price);
//}catch(Exception e) {
//			logger.error(e.getMessage());
	//		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			return productRepository.findByPrice(price);
	}
 //logger.info("product get Successfully");
// return new ResponseEntity<>("Product Get Successfully By Price",HttpStatus.OK);
//}
	

public Object getProductByPriceAndCategory(float price, String category) {
	return productRepository.findByPriceAndCategory(price, category);
}

public Object getProductPriceByRange(float min, float max) {
	  return productRepository.findByPriceBetween(min, max);
		
	}

public Object getProductPriceByRangeAndCategory(float min, float max, String category) {
	  return productRepository.findByPriceBetweenAndCategory(min, max,category);
		
	}

//========================================================================

public Object getProductbyCustomerid(int id) {
	return productRepository.findByCustomerId(id);
}
}
