package com.action;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Invcodes;
import com.service.InvcodesService;

@Controller
@Scope("prototype")
public class InvcodesAction {

	@Resource
	InvcodesService invcodesService;

	// 返回数据
	private String result;
	private String error;
	
	/**
	 * 查询邀请码是否使用
	 * 
	 * @return
	 */
	String invcodes;

	public String findInvcodesInfo() {
		if (invcodesService.findInvcodesInfo(invcodes)) {
			result = "{\"message\":\"无错误\"}";
			return "success";
		} else {
			result = "{\"message\":\"邀请码无效\"}";
			return "success";
		}

	}

	public InvcodesService getInvcodesService() {
		return invcodesService;
	}

	public void setInvcodesService(InvcodesService invcodesService) {
		this.invcodesService = invcodesService;
	}

	public String getInvcodes() {
		return invcodes;
	}

	public void setInvcodes(String invcodes) {
		this.invcodes = invcodes;
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
