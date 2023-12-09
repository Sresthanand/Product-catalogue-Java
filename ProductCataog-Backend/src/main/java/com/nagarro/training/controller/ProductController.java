package com.nagarro.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.dao.ProductRepo;
import com.nagarro.training.model.Product;

@RestController
public class ProductController {
	@Autowired
	ProductRepo repo;
	
	@GetMapping("/allProducts")
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	/*
	 {
   "productBrand" : "MI",
   "productName" : "Redmi note 10",
   "pincodes" : [1,2,3,4,5],
   "productPrice" : 20000
}
	 */
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		repo.save(product);
		return product;
	}
	
	@GetMapping("getProduct/{productCode}")
	@ResponseBody
	public Optional<Product> getProduct(@RequestParam("productCode") Integer productCode) {

				return repo.findByProductCode(productCode);
		
	}
	
	
	//http://localhost:8087/search?productName=&productBrand=&productCode=1
	
	  @GetMapping("/search")
	  @ResponseBody
	    public List<Product> searchProducts(@RequestParam("productName") String productName, @RequestParam("productBrand" ) String productBrand, @RequestParam("productCode") String productCode) {
	        List<Product> products = repo.searchProducts(productName,productBrand, productCode);
	        return products;
	    }
	
	
	
}
