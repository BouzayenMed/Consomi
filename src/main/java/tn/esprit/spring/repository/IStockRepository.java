package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Stock;

@Repository
public interface IStockRepository extends CrudRepository<Stock, Long> {
	@Query(nativeQuery=true,value="select * from stock  where product_product_id = ?1")
	public Stock find_product_stock(@Param(value = "product_product_id") long product_product_id);
}
