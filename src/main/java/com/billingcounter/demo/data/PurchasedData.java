package com.billingcounter.demo.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PurchasedData {

	@NotNull
	@NotBlank
	@NotEmpty
	private String productCode;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String quantity;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductDetails [productCode=" + productCode + ", quantity=" + quantity + "]";
	}
	
	
	
}
