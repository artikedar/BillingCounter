package com.billingcounter.demo.data;

public class ItemizedBill {

	private ProductDetails productDetails;
	private float cost; 
	
	public ProductDetails getProductBase() {
		return productDetails;
	}
	public void setProductBase(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "ItemizedBill [productDetails=" + productDetails + ", cost=" + cost + "]";
	}
	
}
