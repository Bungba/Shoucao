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
	
	/**
	 * 优惠代码验证
	 * @return
	 */
	public String checkVerify() {
		Infos infos = infosService.checkVerify(verify);
		if (infos != null) {
			return "success";
		}
		return "error";
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
}
