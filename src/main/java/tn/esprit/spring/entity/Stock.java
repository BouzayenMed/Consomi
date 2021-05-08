package tn.esprit.spring.entity;



import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table
public class Stock {
	
	
	@Id
	private long stock_id;
	
	private int product_min_qunatity;
	private int product_max_qunatity;
	private int product_curent_quantity;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	private Product product;
	
	
	

	public long getStock_id() {
		return stock_id;
	}

	public Stock(int product_min_qunatity, int product_max_qunatity, int product_curent_quantity, Product product) {
		super();
		this.product_min_qunatity = product_min_qunatity;
		this.product_max_qunatity = product_max_qunatity;
		this.product_curent_quantity = product_curent_quantity;
		this.product = product;
	}

	public void setStock_id(long stock_id) {
		this.stock_id = stock_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int notify_min_reached(){
		
		
		
		
		return product_curent_quantity;
		
	}

	public int getProduct_min_qunatity() {
		return product_min_qunatity;
	}

	public void setProduct_min_qunatity(int product_min_qunatity) {
		this.product_min_qunatity = product_min_qunatity;
	}

	public int getProduct_max_qunatity() {
		return product_max_qunatity;
	}

	public void setProduct_max_qunatity(int product_max_qunatity) {
		this.product_max_qunatity = product_max_qunatity;
	}

	public int getProduct_curent_quantity() {
		return product_curent_quantity;
	}

	public void setProduct_curent_quantity(int product_curent_quantity) {
		this.product_curent_quantity = product_curent_quantity;
	}
	
	
	
	
	
	
}
