package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.IStockRepository;

@Service
public class StockService {

	@Autowired
	IStockRepository stock_rep;
	
	@Autowired
	ProductService prod_serv;
	public void addnewprodstock(int min_quantity ,int curent_quantity,int max_quantity ,long prod_id){
		Product P = prod_serv.getProd_byid(prod_id);
		Stock S = new Stock(min_quantity, max_quantity, curent_quantity, P);
		stock_rep.save(S);
	}
	public List<Stock> getallstock()
	{
		return (List<Stock>) stock_rep.findAll();
	}
	
	public void removeStockbyId(long id){
		stock_rep.deleteById(id);
	}

	public Stock getProdStock(long prod_id){
		return stock_rep.find_product_stock(prod_id);
	}

	public int getCurrent_quantity(long prod_id){

		return stock_rep.find_product_stock(prod_id).getProduct_curent_quantity()		;

	}
	@Autowired
	SendSmsService sms_serv;
	public void remove_quantity(long prod_id,int quantity){
		Stock x = stock_rep.find_product_stock(prod_id);
		if(x.getProduct_curent_quantity()>=quantity){
			x.setProduct_curent_quantity(x.getProduct_curent_quantity()-quantity);
			stock_rep.save(x);
			if(x.getProduct_curent_quantity()< x.getProduct_min_qunatity())
			{
				String body = "Product :"+stock_rep.find_product_stock(prod_id).getProduct().getName().toString()
						+" With id :" + prod_id +"Remain "+x.getProduct_curent_quantity();
				//hne lezem njib tel number te3 user logedin User w nzido l sender
				String to="+216936020";
				sms_serv.sendsms(body,to);
			}
		}
		/*else
		{
			String body = "Product :"+stock_rep.find_product_stock(prod_id).getProduct().getName().toString()
					" With id :"+ 
		}*/
	}
	public int Max_Quantity_to_add(long prod_id){
		System.err.println(stock_rep.find_product_stock(prod_id).getProduct_max_qunatity() - this.getCurrent_quantity(prod_id));
		return stock_rep.find_product_stock(prod_id).getProduct_max_qunatity() - this.getCurrent_quantity(prod_id);



	}
	//returns -1 if total quantity > quantity max| total quantity
	public int add_Quantity_to_stock(int quantity , long prod_id){

		if(this.Max_Quantity_to_add( prod_id)>=quantity){
			Stock s = stock_rep.find_product_stock(prod_id);
			s.setProduct_curent_quantity
			(this.getCurrent_quantity(prod_id)+quantity);
			System.err.println(s.getProduct_curent_quantity());
			stock_rep.save(s);
			return stock_rep.find_product_stock(prod_id).getProduct_curent_quantity();
		}
		else
			return -1	;


	}
}
