package com.billingcounter.demo.service;

import com.billingcounter.demo.data.PurchasedItems;
import com.billingcounter.demo.data.TotalBill;

public interface BillingCounterServiceInterface {

	public TotalBill getItemizedBill(PurchasedItems input);
}
