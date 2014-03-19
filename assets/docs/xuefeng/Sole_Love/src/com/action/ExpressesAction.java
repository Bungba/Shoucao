package com.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Expresses;
import com.service.ExpressService;

@Controller
@Scope("prototype")
public class ExpressesAction {
	@Resource
	ExpressService expressService;

	// 返回数据
	private String result;
	private String error;

	/**
	 * 取得快递列表
	 * 
	 * @return
	 */
	public String findExpressInfo() {
		List<Expresses> list = expressService.findExpInfo();
		JSONArray ja=JSONArray.fromObject(list);
		result=ja.toString();
		error = "{\"message\":\"无错误\"}";
		return "success";
	}

	public ExpressService getExpressService() {
		return expressService;
	}

	public void setExpressService(ExpressService expressService) {
		this.expressService = expressService;
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
