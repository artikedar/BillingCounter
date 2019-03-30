package com.billingcounter.demo.data;

public class ProductDetails {

	private String productName;
	private String productCode;
	private String category; 
	private float rate;
	private float salesTaxPercentage;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getSalesTaxPercentage() {
		return salesTaxPercentage;
	}
	public void setSalesTaxPercentage(float salesTaxPercentage) {
		this.salesTaxPercentage = salesTaxPercentage;
	}
	
	
}
