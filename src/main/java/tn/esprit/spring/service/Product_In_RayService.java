package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Product_In_Ray;
import tn.esprit.spring.repository.Product_In_RayRepository;

@Service
public class Product_In_RayService {

	@Autowired
	Product_In_RayRepository product_in_ray;
	public List<Product_In_Ray> find_product_Ray_byRayId(long ray_id){
		return  product_in_ray.find_product_Ray_byRayId(ray_id);
	}
	public void  add_new_product_in_ray(int min_quantity, int curent_quantity, int max_quantity, Product product) {

		if(this.getProd_In_Ray_By_ProdID(product.getProduct_Id())==null){
			Product_In_Ray New = new Product_In_Ray( min_quantity,  curent_quantity,  max_quantity,  product.getRay(),  product);
			product_in_ray.save(New);		}
		else
			System.err.println("Product exists in the rays");
	}

	public void remove_product_from_ray_ByProdID(long product_id){
		product_in_ray.delete(getProd_In_Ray_By_ProdID(product_id));
	}

	public Product_In_Ray getProd_In_Ray_By_ProdID(long prod_id){
		return product_in_ray.find_product_Ray(prod_id);
	}

	public int getCurrent_quantity_ByProdID(long prod_id){

		return product_in_ray.find_product_Ray(prod_id).getCurent_quantity()		;

	}

	public int get_Max_Quantity_can_be_added(long prod_id){
		//System.err.println("In Max");
		//System.err.println("Curent : "+this.getCurrent_quantity(prod_id));
		//System.err.println("Max :"+product_in_ray.find_product_Ray(prod_id).getMax_quantity());
		//System.err.println(product_in_ray.find_product_Ray(prod_id).getMax_quantity() - this.getCurrent_quantity(prod_id));

		int x = (product_in_ray.find_product_Ray(prod_id).getMax_quantity() )-( this.getCurrent_quantity_ByProdID(prod_id));
		System.err.println("X = "+x);
		return x;




	}
	@Autowired
	StockService prod_stock;

	//returns -1 if total quantity > quantity max| total quantity
	public int add_Quantity_to_ray(int quantity , long prod_id){
		System.err.println("In add_Quantity_to_ray ");
		System.err.println("Curent qnt stock "+prod_stock.getCurrent_quantity(prod_id));
		System.err.println("Max qnty can add "+(get_Max_Quantity_can_be_added(prod_id)));
		if(prod_stock.getCurrent_quantity(prod_id)>=quantity
				&&
				get_Max_Quantity_can_be_added( prod_id)>=quantity){
			System.err.println("In IFFs ");
			Product_In_Ray s = product_in_ray.find_product_Ray(prod_id);
			s.setCurent_quantity
			(this.getCurrent_quantity_ByProdID(prod_id)+quantity);
			System.err.println("Product quantity in ray "+s.getCurent_quantity());
			prod_stock.remove_quantity(prod_id, quantity);
			product_in_ray.save(s);
			return product_in_ray.find_product_Ray(prod_id).getCurent_quantity();
		}
		else
			return -1	;

	}

	//this function called on every sell

	@Autowired
	SendSmsService sms_serv;
	@Autowired
	ProductService prod_serv;
	//Controlle ala quntity li mich yechriha tssir fil front end bil getcurentquqntity
	public void remove_Quantity_from_ray(int quantity , long prod_id){
		Product_In_Ray x = product_in_ray.find_product_Ray(prod_id);
		x.setCurent_quantity(product_in_ray.find_product_Ray(prod_id).getCurent_quantity()-quantity);
		product_in_ray.save(x);
		if(x.getCurent_quantity() <= x.getMin_quantity())
		{
			String body = "Product :"+product_in_ray.find_product_Ray(prod_id).getProduct().getName()
					+" With id :" + prod_id +"Remain "+x.getCurent_quantity();
			//hne lezem njib tel number te3 user logedin User w nzido l sender
			String to="+216936020";
			sms_serv.sendsms(body,to);
		}
		//Update sold in product
		Product P =x.getProduct();
		P.setSold(x.getProduct().getSold()+quantity);
		//Necraziw Prod 9dim fil Bd
		/*calling save() on an object with predefined id will update the corresponding database
		 * record rather than insert a new one, and also explains why save() is not called create().*/
		//ken lahkeya shiha najmo bil audit narfo kol prod wa9tech tbe3 w 9adech tbe3
		//ne5dmo beha f stat :) jaw!!

		prod_serv.AddProduct(P);
	}
}
