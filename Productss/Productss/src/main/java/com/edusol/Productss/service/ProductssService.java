package com.edusol.Productss.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edusol.Productss.model.Productss;
import com.edusol.Productss.repository.ProductssRepository;
import com.google.gson.JsonObject;


@Service
public class ProductssService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductssRepository productssRepository;

public Object getProducts() {
		
		return productssRepository.findAll();
	}


public Object addProduct(Productss productss) {
	logger.info(productss.toString());
	productssRepository.save(productss);
  logger.info("product added Successfully");
	return new ResponseEntity<>("Product added Successfully",HttpStatus.CREATED);
}
public Object getProductById(int id) {
	
	return productssRepository.findById(id);

}

public Object getProductByCategory(String category) {
	
	return productssRepository.findByCategory(category);

}

public Object updateProduct(Productss productss) {
	
	JsonObject response =new JsonObject();
	System.out.println("Request products:" + productss);
	int id = productss.getId();
    try {
	Productss prod = productssRepository.getOne(id);
	System.out.println("Request product :" + prod);

	System.out.println("old product:" + prod);
	prod.setPrice(productss.getPrice());
	System.out.println("New product:" + prod);
	productssRepository.save(prod);
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
		
		productssRepository.deleteById(id);
	}catch(Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
    logger.info("product deleted Successfully");
    return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
}

public Object getProductPrice(float price) {
	//try {
	productssRepository.findByPrice(price);
//}catch(Exception e) {
//			logger.error(e.getMessage());
	//		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			return productssRepository.findByPrice(price);
	}
 //logger.info("product get Successfully");
// return new ResponseEntity<>("Product Get Successfully By Price",HttpStatus.OK);
//}
	

public Object getProductByPriceAndCategory(float price, String category) {
	return productssRepository.findByPriceAndCategory(price, category);
}

public Object getProductPriceByRange(float min, float max) {
	  return productssRepository.findByPriceBetween(min, max);
		
	}

public Object getProductPriceByRangeAndCategory(float min, float max, String category) {
	  return productssRepository.findByPriceBetweenAndCategory(min, max,category);
		
	}

}