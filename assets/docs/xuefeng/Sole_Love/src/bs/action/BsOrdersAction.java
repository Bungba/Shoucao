package bs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Orderdetails;
import com.model.Orders;
import com.model.Users;


import bs.service.BsOrderdetailsService;
import bs.service.BsOrdersService;
import bs.service.BsProductsService;
import bs.service.BsUserService;

@Controller
@Scope("prototype")
public class BsOrdersAction {

	HttpServletRequest request=ServletActionContext.getRequest();
	
	@Resource
	BsOrderdetailsService bsOrderdetailsService;
	@Resource
	BsProductsService bsProductsService;
	@Resource
	BsOrdersService bsOrdersService;
	@Resource
	BsUserService bsUserService;
	
	List<Orders> list=new ArrayList<Orders>();
	List<Orderdetails> list1=new ArrayList<Orderdetails>();
	/**
	 * 查询所用订单
	 * 
	 * @return
	 */
	int oid;
	public String findAllOrdersInfo() {
		request.setAttribute("order", bsOrdersService.findOrderUser());
		request.setAttribute("os", bsOrdersService.findOrderdetails());
		return "success";
	}
	
	int id;
	public String updateOrdersFlag(){
		bsOrdersService.updateOrdersFlag(id);
		return "success";
	}
	
	String result;
	
	public String findUserOrders() {
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if(u!=null){
			List lt=bsOrdersService.findUserOrders(u.getId());
		
			JSONArray ja=JSONArray.fromObject(lt);
			
			result=ja.toString();
			System.out.println(result);
			
			return "success";
		}
		result = "[{\"message\":\"用户未登录\"}]";
		return "success";
	}

	public List<Orderdetails> getList1() {
		return list1;
	}

	public void setList1(List<Orderdetails> list1) {
		this.list1 = list1;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



	public BsOrderdetailsService getBsOrderdetailsService() {
		return bsOrderdetailsService;
	}



	public void setBsOrderdetailsService(BsOrderdetailsService bsOrderdetailsService) {
		this.bsOrderdetailsService = bsOrderdetailsService;
	}



	public BsProductsService getBsProductsService() {
		return bsProductsService;
	}



	public void setBsProductsService(BsProductsService bsProductsService) {
		this.bsProductsService = bsProductsService;
	}



	public BsOrdersService getBsOrdersService() {
		return bsOrdersService;
	}



	public void setBsOrdersService(BsOrdersService bsOrdersService) {
		this.bsOrdersService = bsOrdersService;
	}



	public BsUserService getBsUserService() {
		return bsUserService;
	}



	public void setBsUserService(BsUserService bsUserService) {
		this.bsUserService = bsUserService;
	}


	

}
