package tn.esprit.spring.Controller;



import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Category;

import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.CategoryService;
import tn.esprit.spring.service.RayService;

@Scope(value = "session")
@Controller(value = "RayController") // Name of the bean in Spring IoC
@ELBeanName(value = "RayController") // Name of the bean used by JSF
//@Join(path = "/", to = "/showRay.jsf")
@RestController
@RequestMapping
public class RayController {
	
	private String name_ray_to_add;
	private Ray selcted_ray;
	
	public void im_clicked(){
		System.err.println("I m clicked ");
	}
	public String navigate_to_showprod(long id_ray){
		
		
		System.err.println("************ -__-");
		String navigateTo ="null";
		this.setSelectedRayid( id_ray);
		
	 this.selcted_ray=ray_service.get_ray_byId(this.selectedRayid);
		System.err.println(this.getSelectedRayid());
		navigateTo ="/pages/admin/showprodinray.xhtml?faces-redirect=true";
		return navigateTo;
	}
	private String selectedcat;
	public String showraybycat(String cat){
		String navigateTo ="null";
		System.err.println("***************************AAAAAAAA**********************************");
		System.err.println(cat);
		
		selectedcat =cat;
		//return "showprodinrayavecfilter.xhtml?faces-redirect=true";
		
		String url = "showprodinrayavecfilter.xhtml"; // Your URL here
		navigateTo ="/pages/admin/showRayfilterCat.xhtml?faces-redirect=true";
		return navigateTo;
	}
	//showRayfilterCat

	public List<Category> getcatbyname(){
		
		
		System.err.println("***************************BBBBBBB**********************************");
		List<Category> list = cat_serv.getCategories();
		List<Category> list2 = list.stream()
				.filter(cat -> cat.getName().compareTo(this.selectedcat)==0).
				collect(Collectors.toList());
				
				
		return list2;
	}
	
	
	
	@Autowired
	RayService ray_service;
	
	public List<Ray> getraybycat(long cat_id){
		return  ray_service.getraybycat(cat_id);
	} 
	private Long selectedRayid;

	public Ray newRay;
	
	@PostMapping("/addrayon")
	public void addRay(@RequestBody Ray R)
	{
		ray_service.addRay(R);
	}
	@Autowired
	CategoryService cat_serv;
	public void addRaywithcat(String name,long id_cat)
	{
		System.err.println("how name li jenii ena 5atini -___- ");
	   Category cat;
	   cat =cat_serv.getcatbyid(id_cat);
		Ray R=new Ray(name, cat);
		R.setRayName(name);
		ray_service.addRay(R);
	}
	
	
	@DeleteMapping("/removeRay/{ID}")
	public void removeRay(@PathVariable("ID") Long ID)
	{
		System.err.println("Id   ********* ID : "+ID);
		ray_service.removeRay(ID);
	}
	@GetMapping("/showRay")
	public List<Ray> showRay(){
		return ray_service.showRay();
	}
	@RequestMapping("getraybyid")
	public Ray selectraybyid(@RequestParam("id")Long ID){
		return ray_service.selectraybyid(ID);
	}
	@PutMapping("/updateRay/{id}")
	public void update_ray(@PathVariable("id") Long id, @RequestBody Ray ray)
	{
		ray_service.updateRay(ray, id);
		
	}
	public Long getSelectedRayid() {
		return selectedRayid;
	}
	public void setSelectedRayid(Long selectedRayid) {
		this.selectedRayid = selectedRayid;
	}

	public Ray getNewRay() {
		return newRay;
	}
	public void setNewRay(Ray newRay) {
		this.newRay = newRay;
	}
	public Ray getSelcted_ray() {
		return selcted_ray;
	}
	public void setSelcted_ray(Ray selcted_ray) {
		this.selcted_ray = selcted_ray;
	}


	public String getName_ray_to_add() {
		System.err.println("Get : "+name_ray_to_add);
		return name_ray_to_add;
		
	}


	public void setName_ray_to_add(String name_ray_to_add) {
		System.err.println(" el nom li jè lil set name :"+name_ray_to_add);
		this.name_ray_to_add = name_ray_to_add;
	}
	public String getSelectedcat() {
		return selectedcat;
	}
	public void setSelectedcat(String selectedcat) {
		this.selectedcat = selectedcat;
	}

}
