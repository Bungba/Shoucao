package bs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Products;

import bs.service.BsProductsService;

@Controller
@Scope("prototype")
public class BsProductsAction {
	@Resource
	BsProductsService bsProductsService;
	
	List<Products> list=new ArrayList<Products>();
	public String findProducts(){
		list=bsProductsService.findProducts();
		return "success";
	}
	
	int id; 
	String title;
	String des;
	String thumbnail;
	String price;
	int count;
	
	boolean result;
	public String updateproducts(){
		Products p=new Products();
		p.setId(id);
		p.setTitle(title);
		p.setDes(des);
		p.setThumbnail(thumbnail);
		p.setPrice(Float.parseFloat(price));
		p.setCount(count);
		if (bsProductsService.updateProducts(p)==true) {
			result=true;
		}else{
			result=false;
		}
		return "success";
	}
	
	public String delproducts(){
		Products p=new Products();
		p.setId(id);
		if (bsProductsService.delproducts(p)==true) {
			result=true;
		}else{
			result=false;
		}
		return "success";
	}
	
	
	
	
	
	public BsProductsService getBsProductsService() {
		return bsProductsService;
	}
	public void setBsProductsService(BsProductsService bsProductsService) {
		this.bsProductsService = bsProductsService;
	}
	public List<Products> getList() {
		return list;
	}
	public void setList(List<Products> list) {
		this.list = list;
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getDes() {
		return des;
	}







	public void setDes(String des) {
		this.des = des;
	}







	public String getThumbnail() {
		return thumbnail;
	}







	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}







	public String getPrice() {
		return price;
	}







	public void setPrice(String price) {
		this.price = price;
	}







	public int getCount() {
		return count;
	}







	public void setCount(int count) {
		this.count = count;
	}







	public boolean isResult() {
		return result;
	}







	public void setResult(boolean result) {
		this.result = result;
	}







	public String getTitle() {
		return title;
	}







	public void setTitle(String title) {
		this.title = title;
	}
}
