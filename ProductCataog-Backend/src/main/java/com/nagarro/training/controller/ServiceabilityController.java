package com.nagarro.training.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.dao.ProductDetailsRepo;
import com.nagarro.training.dao.ProductRepo;
import com.nagarro.training.dao.UserRepo;
import com.nagarro.training.model.Product;
import com.nagarro.training.model.ProductDetails;

@RestController
public class ServiceabilityController {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	ProductDetailsRepo pro;
	
	
	@GetMapping("/serviciabilityCheck")
	public Boolean checkPincode(@RequestParam("productCode") Integer productCode,
			@RequestParam("pincode") Integer pincode) {
		
		 Product product = repo.findByProductCode((productCode))
				 .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
		 int[] pincodes = product.getPincodes();
		 if(pincodes.length == 0) {
			 return false;
		 }
		    for (int i = 0; i < pincodes.length; i++) {
		    	System.out.print(pincodes[i]);
		        if (pincodes[i] == pincode) {
		            return true; 
		        }
		    }
		    return false; 
	}
	
	
//	@GetMapping("/getDeliveryDate")
//	public ResponseEntity<String> getDeliveryDate(@RequestParam("productCode") Integer productCode,
//			@RequestParam("pincode") Integer pincode) {
//		boolean result = checkPincode(productCode,pincode);
//		if(result) {
//		 Product product = repo.findByProductCode((productCode))
//				 .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
//		 ProductDetails productDetails = pro.findByProduct(product);
//		 return ResponseEntity.ok(productDetails.getProductDelivery());
//		}else {
//			return ResponseEntity.ok("not possible");
//		}
//	}
	
	@GetMapping("/getDeliveryDate")
	public ResponseEntity<Map<String, String>> getDeliveryDate(
	        @RequestParam("productCode") Integer productCode,
	        @RequestParam("pincode") Integer pincode) {
	    boolean result = checkPincode(productCode, pincode);
	    if (result) {
	        Product product = repo.findByProductCode(productCode)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid productCode"));
	        ProductDetails productDetails = pro.findByProduct(product);

	        Map<String, String> response = new HashMap<>();
	        response.put("deliveryDate", productDetails.getProductDelivery());
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.ok(Collections.singletonMap("error", "not possible"));
	    }
	}


}
