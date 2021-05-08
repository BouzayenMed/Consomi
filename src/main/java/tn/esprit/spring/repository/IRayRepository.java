package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Ray;


@Repository
public interface IRayRepository extends JpaRepository<Ray, Long> {
	
	@Query(nativeQuery=true,value="SELECT * FROM ray  where category_category_id = ?1")
	public List<Ray> find_ray_byCat(@Param(value = "category_category_id") long category_category_id);

}
