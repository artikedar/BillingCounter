package com.billingcounter.demo.component;

import org.springframework.stereotype.Component; 
import org.springframework.util.StringUtils;

import com.billingcounter.demo.data.PurchasedData;
import com.billingcounter.demo.data.PurchasedItems;
import com.billingcounter.demo.exception.IncorrectQuantityValueException;
import com.billingcounter.demo.exception.ProductNotFoundException;
import com.billingcounter.demo.exception.PurchasedDataNotFoundException;
import com.billingcounter.demo.exception.QuantityNotFoundException;
import com.billingcounter.demo.util.Constants;

@Component
public class ProductDetailsValidator {

	public void validateInput(PurchasedItems input) {
		for(PurchasedData data : input.getPurchasedDataList()) {
			if(StringUtils.isEmpty(data))
				throw new PurchasedDataNotFoundException(Constants.PURCHSD_DATA_NOT_FOUND_MSG);
			validateProductCode(data);
			validateQuantity(data); 
		}
	} 

	private void validateQuantity(PurchasedData data) { 
		if(data.getQuantity() == null || StringUtils.isEmpty(data.getQuantity()))  
			throw new QuantityNotFoundException(Constants.QUANTITY_NOT_FOUND_MSG);
		try { 
			Integer.parseInt(data.getQuantity());
		}catch(Exception ex) {
			throw new IncorrectQuantityValueException(Constants.QUANTITY_INCORRECT_MSG); 
		}
	}

	private void validateProductCode(PurchasedData data) {
		if(StringUtils.isEmpty(data.getProductCode()) || data.getProductCode() == null)
			throw new ProductNotFoundException(Constants.PRODCT_CDE_EMPTY_MSG);
		if(!data.getProductCode().matches(Constants.PRODCT_CDE_REGEX))
			throw new ProductNotFoundException(Constants.PRODCT_CDE_INCORRECT_MSG);
	}
}
