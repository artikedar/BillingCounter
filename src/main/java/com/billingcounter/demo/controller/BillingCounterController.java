package com.billingcounter.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billingcounter.demo.component.ProductDetailsValidator;
import com.billingcounter.demo.data.PurchasedItems;
import com.billingcounter.demo.data.TotalBill;
import com.billingcounter.demo.service.BillingCounterServiceInterface;

@RestController
@RequestMapping("/bills")
public class BillingCounterController {
	
	private BillingCounterServiceInterface billingCounterService;
	private ProductDetailsValidator productDetailsValidator;
	
	@Autowired
	public BillingCounterController(BillingCounterServiceInterface billingCounterService,
			ProductDetailsValidator productDetailsValidator) { 
		super();  
		this.billingCounterService = billingCounterService;
		this.productDetailsValidator = productDetailsValidator;
	}

	@PostMapping
	public ResponseEntity<TotalBill> getItemizedBill(@Valid @RequestBody PurchasedItems input){
		productDetailsValidator.validateInput(input);
		return new ResponseEntity<>(billingCounterService.getItemizedBill(input), HttpStatus.OK);
		
	}
}
