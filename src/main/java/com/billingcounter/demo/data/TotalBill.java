package com.billingcounter.demo.data;

import java.util.List;

public class TotalBill {

	private List<ItemizedBill> itemizedBill;
	private Float total;
	
	public List<ItemizedBill> getItemizedBill() {
		return itemizedBill;
	}
	public void setItemizedBill(List<ItemizedBill> itemizedBill) {
		this.itemizedBill = itemizedBill;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
}
