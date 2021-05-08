package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Product;


@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
	
	@Query(nativeQuery=true,value="select * from product  where ray_ray_id = ?1")
	public List<Product> find_products_ByRayId(@Param(value = "ray_ray_id") Long ray_id);
	
	@Query(nativeQuery=true,value="select * from product  where name = ?1")
	public List<Product> findByName(@Param(value = "name")String Name);

	List<Product> findByBarcode(String barcode);


	long countByCategory(String category);

	long count();
}
