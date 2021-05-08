package tn.esprit.spring.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


@Entity
public class Ray {
	
	@Id
	@GeneratedValue (strategy=  GenerationType.IDENTITY)
	private Long ray_Id;
	
	private String RayName;
	
	@NotNull
	@ManyToOne()
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy ="ray")
	private Set<Product> products;

	@OneToMany(mappedBy="ray")
	@JsonIgnore
	private List<Product_In_Ray> product_in_ray;

	public Ray(Long ray_Id, String rayName, Category category) {
		super();
		this.ray_Id = ray_Id;
		RayName = rayName;
		this.category = category;
	}
	

	public Ray() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ray(String rayName, Category category) {
		super();
		RayName = rayName;
		this.category = category;
	}


	public Long getRay_Id() {
		return ray_Id;
	}

	public void setRay_Id(Long ray_Id) {
		this.ray_Id = ray_Id;
	}

	public String getRayName() {
		return RayName;
	}

	public void setRayName(String rayName) {
		RayName = rayName;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public List<Product_In_Ray> getProduct_in_ray() {
		return product_in_ray;
	}


	public void setProduct_in_ray(List<Product_In_Ray> product_in_ray) {
		this.product_in_ray = product_in_ray;
	}




}
