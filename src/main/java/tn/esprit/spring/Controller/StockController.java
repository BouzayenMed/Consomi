package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;


@Scope(value = "session")
@Controller(value = "StockController") // Name of the bean in Spring IoC
@ELBeanName(value = "StockController") // Name of the bean used by JSF
//@Join(path = "/", to = "/login.jsf")
@RestController
@RequestMapping("ApiStock")
public class StockController {
	@Autowired
	StockService stock_service;
	private int maxcnt;
	private int ccnt;
	private int mincnt;
	private long id_prod_to_add;
	

	public List<Stock> getallstock()
	{
		return  stock_service.getallstock();
	}
	
	public void removeStockbyId(long id){
		
		System.err.println("Id li wsoll ena 5atini :p "+ id);
		stock_service.removeStockbyId(id);
	}
	
	public void addnewprodstock(int min_quantity ,int curent_quantity,int max_quantity ,long prod_id){
		stock_service.addnewprodstock(min_quantity, curent_quantity, max_quantity, prod_id);
	}
	
	@RequestMapping("/addprodqauntitytostock")
	public int  addprodqauntitytostock(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		 
	System.err.println("Max quantity can be added : "+stock_service.Max_Quantity_to_add(prod_id)); 	
	return stock_service.add_Quantity_to_stock(quantity, prod_id);
	}
	
	@RequestMapping("/getprodstock")
	public Stock getProdStock(@RequestParam("prod_id")long prod_id){
		return stock_service.getProdStock( prod_id);
	}

	public int getMaxcnt() {
		return maxcnt;
	}

	public void setMaxcnt(int maxcnt) {
		this.maxcnt = maxcnt;
	}

	public int getmincnt() {
		return mincnt;
	}

	public void setmincnt(int mincnt) {
		this.mincnt = mincnt;
	}

	public long getId_prod_to_add() {
		return id_prod_to_add;
	}

	public void setId_prod_to_add(long id_prod_to_add) {
		this.id_prod_to_add = id_prod_to_add;
	}

	public int getCcnt() {
		return ccnt;
	}

	public void setCcnt(int ccnt) {
		this.ccnt = ccnt;
	}

}
