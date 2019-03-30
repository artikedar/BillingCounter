package com.billingcounter.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product{
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_Code")
	private String productCode;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_rate")
	private Float productRate;
	
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductRate() {
		return productRate;
	}

	public void setProductRate(Float productRate) {
		this.productRate = productRate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
