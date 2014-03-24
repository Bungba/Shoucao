package com.action;

import javax.annotation.Resource;

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

	public String findDisInfo() {
		
		Salers saler = (Salers) ServletActionContext.getRequest().getSession().getAttribute("Saler");
		if (saler != null) {
			Discounts d = discountsService.findDisInfo(saler.getId());
			JSONObject jo = JSONObject.fromObject(d);
			result = jo.toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"该用户不是首草使者\"}";
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
}
