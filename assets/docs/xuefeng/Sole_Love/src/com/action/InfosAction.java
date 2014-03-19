package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Infos;
import com.service.InfosService;

@Controller
@Scope("prototype")
public class InfosAction {

	@Resource
	InfosService infosService;

	String verify;
	
	// 返回数据
	private String result;
	private String error;
	
	/**
	 * 优惠代码验证
	 * @return
	 */
	public String checkVerify() {
		Infos infos = infosService.checkVerify(verify);
		if (infos != null) {
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"优惠代码不存在\"}";
		return "success";
	}

	public InfosService getInfosService() {
		return infosService;
	}

	public void setInfosService(InfosService infosService) {
		this.infosService = infosService;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
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
