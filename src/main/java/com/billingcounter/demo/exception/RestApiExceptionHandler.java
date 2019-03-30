package com.billingcounter.demo.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus; import
org.springframework.http.ResponseEntity; import
org.springframework.web.bind.MethodArgumentNotValidException; import
org.springframework.web.bind.annotation.ControllerAdvice; import
org.springframework.web.bind.annotation.ExceptionHandler; import
org.springframework.web.bind.annotation.ResponseBody; import
org.springframework.web.bind.annotation.ResponseStatus;

import com.billingcounter.demo.error.ErrorDetails;
import com.billingcounter.demo.util.Constants;

@ControllerAdvice(basePackages = "com.billingcounter.demo") 
public class RestApiExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
 
	@ExceptionHandler(MethodArgumentNotValidException.class)

	@ResponseBody 
	public ErrorDetails handleFieldValidationExceptions(MethodArgumentNotValidException ex) { 
		return ex.getBindingResult() .getAllErrors().stream() .map(error -> new
					ErrorDetails(Constants.INPUT_PARAM_SRC + ex.getMessage(),
							HttpStatus.BAD_REQUEST.value(), error.getDefaultMessage(), true))
			.collect(Collectors.toList()).get(0); }

	@ExceptionHandler(Exception.class) 
	public final ResponseEntity<Object> handleAllExceptions(){ ErrorDetails errorDetails = new ErrorDetails(Constants.SERVER,
			HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SRVR_ERROR_MSG,
			false); 
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
	} 

	@ExceptionHandler(ProductNotFoundException.class) 
	public final ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex){ 
		ErrorDetails errorDetails = new ErrorDetails(Constants.INPUT_PARAM_SRC, HttpStatus.NOT_FOUND.value(),
				ex.getSource(), ProductNotFoundException.RECOVERABLE); 
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(QuantityNotFoundException.class) 
	public final ResponseEntity<Object> handleQuantityNotFoundException(QuantityNotFoundException ex){ ErrorDetails
		errorDetails = new ErrorDetails(Constants.INPUT_PARAM_SRC, HttpStatus.NOT_FOUND.value(),
				ex.getSource(), QuantityNotFoundException.RECOVERABLE); 
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(ProductDoesNotExistException.class) 
	public final ResponseEntity<Object> handleProductDoesNotExistException(ProductDoesNotExistException ex){ 
		ErrorDetails errorDetails = new ErrorDetails(Constants.INPUT_PARAM_SRC, HttpStatus.NOT_FOUND.value(),
				ex.getSource(), ProductDoesNotExistException.RECOVERABLE); 
		return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT); 
	}
	
	@ExceptionHandler(PurchasedDataNotFoundException.class) 
	public final ResponseEntity<Object> handlePurchasedDataNotFoundException(PurchasedDataNotFoundException ex){ ErrorDetails
		errorDetails = new ErrorDetails(Constants.INPUT_PARAM_SRC, HttpStatus.NOT_FOUND.value(),
				ex.getSource(), IncorrectQuantityValueException.RECOVERABLE); 
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(IncorrectQuantityValueException.class) 
	public final ResponseEntity<Object> handleIncorrectQuantityValueException(IncorrectQuantityValueException ex){ ErrorDetails
		errorDetails = new ErrorDetails(Constants.INPUT_PARAM_SRC, HttpStatus.NOT_FOUND.value(),
				ex.getSource(), IncorrectQuantityValueException.RECOVERABLE); 
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
	}

}
