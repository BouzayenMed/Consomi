package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository cat_rep;
	
	public List<Category> getCategories(){
		return cat_rep.findAll();
	}
	
	public Category getcatbyid(long id){
		return cat_rep.findById(id).get();
	}
}
