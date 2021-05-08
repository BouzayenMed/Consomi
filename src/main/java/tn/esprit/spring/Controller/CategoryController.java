package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.service.CategoryService;

@Scope(value = "session")
@Controller(value = "CatController") // Name of the bean in Spring IoC
@ELBeanName(value = "CatController") 
@RestController
@RequestMapping("Api_Cat")
public class CategoryController {
	
	private long selected_catid ;
	
	private Category slected_cat;
	
	@Autowired
	CategoryService cat_serv;
	
	
	public Category getcatbyid(long id){
		return cat_serv.getcatbyid(id);
	}
	
	public List<Category>getcategories(){
		return cat_serv.getCategories();
	}

	public long getSelected_catid() {
		return selected_catid;
	}

	public void setSelected_catid(long selected_catid) {
		this.selected_catid = selected_catid;
	}

	public Category getSlected_cat() {
		return slected_cat;
	}

	public void setSlected_cat(Category slected_cat) {
		this.slected_cat = slected_cat;
	}

}
