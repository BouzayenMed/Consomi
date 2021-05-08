package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Product;

import tn.esprit.spring.repository.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	IProductRepository product_rep;
	
	public Product getProd_byid(long id){
		return product_rep.findById(id).get();
	}
	public List<Product> getallprods(){
		return (List<Product>) product_rep.findAll();
	}
	
	public void AddProduct(Product produit){
		produit.setSold(0);
		product_rep.save(produit);
	}
	
	@Query("select * from product  where ray_ray_id = ?1")
	public List<Product> find_products_ByRayId(@Param(value = "ray_ray_id") Long ray_id){
		
		return product_rep.find_products_ByRayId(ray_id);
		
		
	}

	@Autowired
	IProductRepository productRepository;

	@Transactional
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Transactional
	public List<Product> findByBarcode(String barcode) {
		return productRepository.findByBarcode(barcode);
	}
	


	@Transactional
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
		
	}

	@Transactional
	public boolean deleteProduct(Long productId) throws Exception {
		Optional<Product> Optionalproduct =	productRepository.findById(productId);
		Optionalproduct.orElseThrow(() -> new Exception("Product not found To delete"));
		productRepository.deleteById(productId);
		return !productRepository.existsById(productId);

	}

	@Transactional
	public boolean addProduct(Product product) {
		return productRepository.save(product) != null;
	}

	@Transactional
	public boolean updateProduct(Product product) throws Exception {
		Optional<Product> Optionalproduct = productRepository.findById(product.getProduct_Id());
		Optionalproduct.orElseThrow(() -> new Exception("Product not found"));
		return productRepository.save(product) != null;
	}

	@Transactional
	public boolean Addlikes(Product product) throws Exception {
		Optional<Product> Optionalproduct = productRepository.findById(product.getProduct_Id());
		Optionalproduct.orElseThrow(() -> new Exception("Product not found"));
		Product p=new Product();
		p=Optionalproduct.get();
		p.setLikes(p.getLikes()+1);
		return productRepository.save(p) != null;
	}
	
	@Transactional
	public boolean Dislike(Product product) throws Exception {
		Optional<Product> Optionalproduct = productRepository.findById(product.getProduct_Id());
		Optionalproduct.orElseThrow(() -> new Exception("Product not found"));
		Product p=new Product();
		p=Optionalproduct.get();
		p.setLikes(p.getLikes()-1);
		return productRepository.save(p) != null;
	}
	
	
	
	@Transactional
	public Long count() {

		return productRepository.count();
	}

	
	
	

	

}
