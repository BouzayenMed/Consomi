package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")
public class Product {
	
	@Transient
	private int x;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Product_Id;
	
	@Column(name = "name")
	private String Name;

	private double Buy_Price;
	private double Sell_Price;
	@Lob
	private byte[] Images;
	private String Description;
	private String Brand;
	private String barcode;
	
	private int sold;
	

	@Column(name = "materiel")
	private String materiel;

	@Column(name = "rating")
	private Float rating;

	@Column(name = "likes")
	private Integer likes;


	@ManyToOne
	private Category category;

	@ManyToOne
	private Ray ray;

	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<Product_In_Ray> product_in_ray;
	
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<Stock> stocks;

	

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double buy_Price, double sell_Price, byte[] images, String description, String brand,
			Category category) {
		super();
		Name = name;
		Buy_Price = buy_Price;
		Sell_Price = sell_Price;
		Images = images;
		Description = description;
		Brand = brand;
		this.category = category;
	}

	public Product(long product_Id, String name, double buy_Price, double sell_Price, byte[] images, String description,
			String brand, Category category) {
		super();
		Product_Id = product_Id;
		Name = name;
		Buy_Price = buy_Price;
		Sell_Price = sell_Price;
		Images = images;
		Description = description;
		Brand = brand;
		this.category = category;
	}

	public long getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(long product_Id) {
		Product_Id = product_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getBuy_Price() {
		return Buy_Price;
	}

	public void setBuy_Price(double buy_Price) {
		Buy_Price = buy_Price;
	}

	public double getSell_Price() {
		return Sell_Price;
	}

	public void setSell_Price(double sell_Price) {
		Sell_Price = sell_Price;
	}

	public byte[] getImages() {
		return Images;
	}

	public void setImages(byte[] images) {
		Images = images;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public String getBarCode() {
		return barcode;
	}

	public void setBarCode(String barCode) {
		barcode = barCode;
	}

	public List<Product_In_Ray> getProduct_in_ray() {
		return product_in_ray;
	}

	public void setProduct_in_ray(List<Product_In_Ray> product_in_ray) {
		this.product_in_ray = product_in_ray;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public String getMateriel() {
		return materiel;
	}

	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		System.err.println("this is X "+x);
		this.x = x;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	
}