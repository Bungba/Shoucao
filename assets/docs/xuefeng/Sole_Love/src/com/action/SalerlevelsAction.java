package com.action;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Salerlevels;
import com.model.Users;
import com.service.SalerlevelsService;

@Controller
@Scope("prototype")
public class SalerlevelsAction {

	@Resource
	SalerlevelsService salerlevelsService;

	// 返回数据
	private String result;
	private String error;

	/**
	 * 使者等级机制
	 * 
	 * @return
	 */
	public String findSalerlevelsInfo() {
		Salerlevels salerlevels = salerlevelsService.findSalerlevelsInfo();
		JSONObject jo = JSONObject.fromObject(salerlevels);
		StringBuffer sb=new StringBuffer();
		sb.append(jo.toString());
		sb.append("{\"message\":\"无错误\"}");
		result=sb.toString();
		return "success";
	}

	/**
	 * 当前用户使者等级
	 * 
	 * @return
	 */
	public String userSalerLevel() {
		
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			Salerlevels salerlevels = salerlevelsService.userSalerLevel(user
					.getId());
			JSONObject jo = JSONObject.fromObject(salerlevels);
			StringBuffer sb=new StringBuffer();
			sb.append(jo.toString());
			sb.append("{\"message\":\"无错误\"}");
			result=sb.toString();
			return "success";
		}
		result = "{\"message\":\"用户未登录\"}";
		return "success";
	}

	public SalerlevelsService getSalerlevelsService() {
		return salerlevelsService;
	}

	public void setSalerlevelsService(SalerlevelsService salerlevelsService) {
		this.salerlevelsService = salerlevelsService;
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
