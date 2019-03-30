package com.billingcounter.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingcounter.demo.data.ItemizedBill;
import com.billingcounter.demo.data.ProductDetails;
import com.billingcounter.demo.data.PurchasedData;
import com.billingcounter.demo.data.PurchasedItems;
import com.billingcounter.demo.data.TotalBill;
import com.billingcounter.demo.entity.Product;
import com.billingcounter.demo.exception.ProductDoesNotExistException;
import com.billingcounter.demo.repository.ProductRepository;
import com.billingcounter.demo.util.Constants;

@Service
public class BillingCounterService implements BillingCounterServiceInterface{

	private ProductRepository productRepository;

	@Autowired
	public BillingCounterService(ProductRepository productRepository) {
		super(); 
		this.productRepository = productRepository;  
	} 
 
	@Override
	public TotalBill getItemizedBill(PurchasedItems purchasedItemsList) {
		List<ItemizedBill> itemizedBillList = new ArrayList<>(); 
		TotalBill totalBill = new TotalBill();
		purchasedItemsList.getPurchasedDataList().stream().forEach(
				item -> {   
					Product product = productRepository.findProductByProductCode(item.getProductCode());
				Optional.ofNullable(product).orElseThrow(() -> new ProductDoesNotExistException(Constants.PRODCT_DOES_NOT_EXIST_MSG));
				float cost = calculateCostOfProduct(product, item);
				itemizedBillList.add(getItemizedBill(cost, product));
				});
		
		totalBill.setItemizedBill(itemizedBillList);
		totalBill.setTotal(calculateTotal(itemizedBillList));
		return totalBill;
	}

	private Float calculateTotal(List<ItemizedBill> itemizedBillList) {
		Float total = 0.0f;
		for(ItemizedBill item : itemizedBillList) {
			total = total + item.getCost();
		}
		return total;
	} 

	private ItemizedBill getItemizedBill(float cost, Product product) {
		ItemizedBill itemizedBill = new ItemizedBill();
		itemizedBill.setCost(cost);
		ProductDetails productDetails = new ProductDetails();
		productDetails.setCategory(product.getCategory().getCategory());
		productDetails.setProductCode(product.getProductCode());
		productDetails.setProductName(product.getProductName());
		productDetails.setRate(product.getProductRate());
		productDetails.setSalesTaxPercentage(product.getCategory().getTax());
		itemizedBill.setProductBase(productDetails);
		return itemizedBill;
	}

	private float calculateCostOfProduct(Product product, PurchasedData input) {
		float rate = product.getProductRate();
		float tax = product.getCategory().getTax();
		return ( rate + ((rate * tax)/100) ) * Integer.parseInt(input.getQuantity());
	}

}
