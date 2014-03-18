package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Users;
import com.service.SalerlevelsService;

@Controller
@Scope("prototype")
public class SalerlevelsAction {

	@Resource
	SalerlevelsService salerlevelsService;

	/**
	 * 使者等级机制
	 * 
	 * @return
	 */
	public String findSalerlevelsInfo() {
		salerlevelsService.findSalerlevelsInfo();
		return "success";
	}

	public String userSalerLevel() {
		/*Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			
			return "success";
		}*/
		salerlevelsService.userSalerLevel(1);
		return "error";
	}
}
