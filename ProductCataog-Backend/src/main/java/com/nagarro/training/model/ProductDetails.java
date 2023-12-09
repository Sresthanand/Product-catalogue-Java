package com.nagarro.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import com.nagarro.training.model.Product;

@Entity
public class ProductDetails {

	@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
	int productId;
	String productDesc;
	String productColor;
	String productGender;
	String productSize;
	String productDelivery;
	
	 @Column(name="image")
		String  image;

	public ProductDetails(int productId, String productDesc, String productColor, String productGender,
			String productSize, String productDelivery, String image) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
		this.productColor = productColor;
		this.productGender = productGender;
		this.productSize = productSize;
		this.productDelivery = productDelivery;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToOne
	private Product product;

	public ProductDetails() {
		super();
	}

	public ProductDetails(String productDesc, String productColor, String productGender, String productSize, String productDelivery) {
		super();
		this.productDesc = productDesc;
		this.productColor = productColor;
		this.productGender = productGender;
		this.productSize = productSize;
		this.productDelivery = productDelivery;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductGender() {
		return productGender;
	}

	public void setProductGender(String productGender) {
		this.productGender = productGender;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductDelivery() {
		return productDelivery;
	}

	public void setProductDelivery(String productDelivery) {
		this.productDelivery = productDelivery;
	}
	
	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productDesc=" + productDesc + ", productColor="
				+ productColor + ", productGender=" + productGender + ", productPrice="+", productSize=" + productSize + ", productDelivery=" + productDelivery + ", product=" + product
				+ "]";
	}

}
