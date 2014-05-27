package com.action;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Discounts;
import com.model.Salers;
import com.service.DiscountsService;

@Controller
@Scope("prototype")
public class DiscountsAction {

	@Resource
	DiscountsService discountsService;

	// 返回数据
	private String result;
	private String error;

	String year;
	
	public String findYearDisInfo() {
		Salers saler = (Salers) ServletActionContext.getRequest().getSession()
				.getAttribute("Saler");
		if (saler != null) {
			List<Discounts> list = discountsService.findYearDisInfo(saler.getId(), year);
			JSONArray ja=JSONArray.fromObject(list);
			result = ja.toString();
			return "success";
		}
		result = "[{\"message\":\"该用户不是首草使者\"}]";
		return "success";
	}

	String month;

	public String findMonthDisInfo() {
		Salers saler = (Salers) ServletActionContext.getRequest().getSession()
				.getAttribute("Saler");
		if (saler != null) {
			List<Discounts> list = discountsService.findMonthDisInfo(saler.getId(), month);
			JSONArray ja=JSONArray.fromObject(list);
			result = ja.toString();
			return "success";
		}
		result = "[{\"message\":\"该用户不是首草使者\"}]";
		return "success";
	}
	
	public String findMonthOrders(){
		Salers saler = (Salers) ServletActionContext.getRequest().getSession()
				.getAttribute("Saler");
		if (saler != null) {
			List monthOrdersList = discountsService.findMonthOrders(year, month);
			JSONArray ja=JSONArray.fromObject(monthOrdersList);
			result = ja.toString();
			return "success";
		}
		result = "[{\"message\":\"该用户不是首草使者\"}]";
		return "success";
	}
	
	public DiscountsService getDiscountsService() {
		return discountsService;
	}

	public void setDiscountsService(DiscountsService discountsService) {
		this.discountsService = discountsService;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
