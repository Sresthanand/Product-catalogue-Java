package com.nagarro.training.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.dao.ProductDetailsRepo;
import com.nagarro.training.dao.ProductRepo;
import com.nagarro.training.model.Product;
import com.nagarro.training.model.ProductDetails;
import com.nagarro.training.model.User;

@RestController
public class ProductDetailsController {
	@Autowired
	ProductDetailsRepo repo;
	
	@Autowired
	private ProductRepo pro;
	
	
	/*
	  {"productDesc" : "sssskkkk",
	 "productColor":"Blue",
	"productGender": "male",
 "productPrice" : 40000,
 "productSize" :"xxl",
 "productDelivery" : "3rd Nov 2000",
 "image" : "https://n4.sdlcdn.com/imgs/j/p/9/Mamaearth-Face-Wash-100-mL-SDL612279297-1-fd4b1.jpg"
}
	 */
	
	@PostMapping("/addProductDetails")
	public ProductDetails addProduct(@RequestBody ProductDetails productDetails, @RequestParam("productCode") Integer productCode) throws IllegalArgumentException {
	    Product product = pro.findByProductCode(productCode)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
	    System.out.println(product);
	    productDetails.setProduct(product);
	    productDetails.setImage(product.getImage());
	    System.out.println(productDetails);
	    repo.save(productDetails);
	    return productDetails;
	}
	
	 @GetMapping("/getProductDetails")
	  @ResponseBody
	    public ProductDetails getProductDetails(  @RequestParam("productCode") Integer productCode) {
		 Product product = pro.findByProductCode(productCode)
				 .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
	        ProductDetails productDetails = repo.findByProduct(product);
	        return productDetails;
	    }

	 @GetMapping("/getPrice")
	 public Integer getPriceByProductCode(@RequestParam("productCode") Integer productCode) {
		 Product product = pro.findByProductCode(productCode)
				 .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
//	        ProductDetails productDetails = repo.findByProduct(product);
	        return product.getProductPrice();
	 }
	 //http://localhost:8087/getAllPrices?productCodes=1,2
	 
	 /*
	  {
	"product_desc" : "neww",
	 "productColor":"Blue",
	"productGender": "male",
 "productPrice" : 1234,
 "productSize" :"xxl",
 "productDelivery" : "9th march 2024"
}*/
	 
	 @GetMapping("/getAllPrices")
	 public List<Integer> getPricesByProductCodes(@RequestParam("productCodes") String productCodes) {
	     ArrayList<Integer> prices = new ArrayList<>();
	     String[] productCodeArray = productCodes.split(",");
	     for (String code : productCodeArray) {
	         Integer productCode = Integer.parseInt(code.trim());
	         Product product = pro.findByProductCode(productCode)
	                 .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
	         prices.add(product.getProductPrice());
	     }

	     return prices;
	 }

	 
	
	
	
	
}
