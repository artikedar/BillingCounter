package com.billingcounter.demo.data;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class PurchasedItems {

	@NotEmpty
	private List<PurchasedData> purchasedDataList;

	public List<PurchasedData> getPurchasedDataList() {
		return purchasedDataList;
	}

	public void setPurchasedDataList(List<PurchasedData> purchasedDataList) {
		this.purchasedDataList = purchasedDataList;
	}
	
	
	
	
}
