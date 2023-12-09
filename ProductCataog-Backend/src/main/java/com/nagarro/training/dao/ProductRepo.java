package com.nagarro.training.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.model.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p WHERE " +
		       "(:productName is null or p.productName LIKE CONCAT('%', :productName, '%')) AND " +
		       "(:productBrand is null or p.productBrand LIKE CONCAT('%', :productBrand, '%')) AND " +
		       "(:productCode is null or p.productCode LIKE CONCAT('%', :productCode, '%'))")
		List<Product> searchProducts( String productName,
		                              String productBrand,
		                              String productCode);
	 Optional<Product> findByProductCode(Integer productCode);

	

}
