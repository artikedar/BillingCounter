package com.billingcounter.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name= "category")
	private String category;
	
	@Column(name = "tax")
	private Float tax;

	@OneToMany(mappedBy = "category")
	private List<Product> productBaseList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public List<Product> getProductBaseList() {
		return productBaseList;
	}

	public void setProductBaseList(List<Product> productBaseList) {
		this.productBaseList = productBaseList;
	}

	


	
	
}
