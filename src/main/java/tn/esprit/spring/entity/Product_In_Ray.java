package tn.esprit.spring.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity

public class Product_In_Ray {
	
	
	public Product_In_Ray() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_In_Ray(int min_quantity, int curent_quantity, int max_quantity, Ray ray, Product product) {
		super();
		this.min_quantity = min_quantity;
		this.curent_quantity = curent_quantity;
		this.max_quantity = max_quantity;
		this.ray = ray;
		this.product = product;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int min_quantity;
	private int curent_quantity;
	
	private int max_quantity;
	
	@ManyToOne
	private Ray ray;
	
	@ManyToOne
	private Product product;

	public int getMin_quantity() {
		return min_quantity;
	}

	public void setMin_quantity(int min_quantity) {
		this.min_quantity = min_quantity;
	}

	public int getCurent_quantity() {
		return curent_quantity;
	}

	public void setCurent_quantity(int curent_quantity) {
		this.curent_quantity = curent_quantity;
	}

	public int getMax_quantity() {
		return max_quantity;
	}

	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}

	public Ray getRay() {
		return ray;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
