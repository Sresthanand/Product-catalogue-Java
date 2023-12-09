package com.nagarro.training.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productCode;
	String productName;
	String productBrand;
	int[] pincodes;
	int productPrice;
	 @Column(name="image")
		String  image;

	public Product(int productCode, String productName, String productBrand, int[] pincodes, int productPrice,
			String image) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.pincodes = pincodes;
		this.productPrice = productPrice;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToOne(mappedBy = "product")
	private ProductDetails details;

	public Product() {
		super();
	}

	public Product(int productCode, String productName, String productBrand) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
	}

	public Product(int productCode, String productName, String productBrand, int[] pincodes) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.pincodes = pincodes;
	}

	public int[] getPincodes() {
		return pincodes;
	}

	public void setPincodes(int[] pincodes) {
		this.pincodes = pincodes;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", details=" + details + "]";
	}

}
