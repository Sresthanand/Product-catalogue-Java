package com.nagarro.training.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.training.model.Product;
import com.nagarro.training.model.ProductDetails;
import com.nagarro.training.model.User;

public interface ProductDetailsRepo extends JpaRepository<ProductDetails,String > {


	ProductDetails findByProduct(Product product);
}
