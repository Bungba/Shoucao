package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Orderdetails;
import com.model.Orders;
import com.model.Products;
import com.model.Users;
import com.service.OrderdetailsService;
import com.service.OrdersService;
import com.service.ProductsService;

@Controller
@Scope("prototype")
public class OrdersAction {

	@Resource
	OrdersService ordersService;
	@Resource
	OrderdetailsService orderdetailsService;
	@Resource
	ProductsService productsService;

	List<Products> products;
	Orders orders;
	int count;// ������Ʒ����

	// ��������
	private String result;
	private String error;

	/**
	 * �ύ����
	 * 
	 * @return
	 */
	public String addOrdersInfo() {

		List<Orders> list = new ArrayList<Orders>();
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");// ȡ��session�е�User
		if (user != null) {// �ж��û��Ƿ��¼
			orders.setUid(user.getId());
			list = ordersService.addOrdersInfo(orders);// �õ����ι��򶩵�
			List<Orderdetails> oList = new ArrayList<Orderdetails>();
			if (list.iterator().hasNext()) {
				oList = orderdetailsService.addOrderdetailsInfo(list.get(0)
						.getId(), products, count);// ���ι��򶩵�����
			}
			JSONArray ja = new JSONArray();
			ja.add(list);
			ja.add(oList);
			result = ja.toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
	}

	/**
	 * ��ѯ�û����ö���
	 * 
	 * @return
	 */
	public String findAllOrdersInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			result = orderdetailsService.findOrderdetailsInfo(user.getId()).toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public OrderdetailsService getOrderdetailsService() {
		return orderdetailsService;
	}

	public void setOrderdetailsService(OrderdetailsService orderdetailsService) {
		this.orderdetailsService = orderdetailsService;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductsService getProductsService() {
		return productsService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
