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
	int count;// 订单产品数量

	// 返回数据
	private String result;
	private String error;

	/**
	 * 提交订单
	 * 
	 * @return
	 */
	public String addOrdersInfo() {

		List<Orders> list = new ArrayList<Orders>();
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");// 取得session中的User
		if (user != null) {// 判断用户是否登录
			orders.setUid(user.getId());
			list = ordersService.addOrdersInfo(orders);// 得到本次购买订单
			List<Orderdetails> oList = new ArrayList<Orderdetails>();
			if (list.iterator().hasNext()) {
				oList = orderdetailsService.addOrderdetailsInfo(list.get(0)
						.getId(), products, count);// 本次购买订单详情
			}
			JSONArray ja = new JSONArray();
			ja.add(list);
			ja.add(oList);
			result = ja.toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"用户未登录\"}";
		return "success";
	}

	/**
	 * 查询用户所用订单
	 * 
	 * @return
	 */
	public String findAllOrdersInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			result = orderdetailsService.findOrderdetailsInfo(user.getId()).toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"用户未登录\"}";
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
