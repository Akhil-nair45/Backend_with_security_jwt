package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String productName;
	
	private String description;
	
	private Double price;
	
	private int qunatity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", productName=" + productName + ", description=" + description + ", price=" + price
				+ ", qunatity=" + qunatity + "]";
	}

	public Model(int id, String productName, String description, Double price, int qunatity) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.qunatity = qunatity;
	}

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 	
}
