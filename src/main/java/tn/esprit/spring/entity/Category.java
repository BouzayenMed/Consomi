package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Category_Id ;
	private String Name;

	public Category(String name, Set<Product> prodcuts) {
		super();
		Name = name;
		this.prodcuts = prodcuts;
	}

	public Category(long category_Id, String name, Set<Product> prodcuts) {
		super();
		Category_Id = category_Id;
		Name = name;
		this.prodcuts = prodcuts;
	}

	@JsonIgnore
	@OneToMany(mappedBy="category")
	private Set<Product> prodcuts;

	@JsonIgnore
	@OneToMany(mappedBy ="category")
	private Set<Ray> rays;

	public Category(long category_Id, String name, Set<Product> prodcuts, Set<Ray> rays) {
		super();
		Category_Id = category_Id;
		Name = name;
		this.prodcuts = prodcuts;
		this.rays = rays;
	}

	public long getCategory_Id() {
		return Category_Id;
	}

	public void setCategory_Id(long category_Id) {
		Category_Id = category_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Set<Product> getProdcuts() {
		return prodcuts;
	}

	public void setProdcuts(Set<Product> prodcuts) {
		this.prodcuts = prodcuts;
	}

	public Set<Ray> getRays() {
		return rays;
	}

	public void setRays(Set<Ray> rays) {
		this.rays = rays;
	}

}
