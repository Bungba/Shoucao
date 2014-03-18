package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Salers;
import com.service.DiscountsService;

@Controller
@Scope("prototype")
public class DiscountsAction {

	@Resource
	DiscountsService discountsService;

	public String findDisInfo() {
		Salers saler = (Salers) ServletActionContext.getRequest().getAttribute(
				"Saler");
		if (saler != null) {
			discountsService.findDisInfo(saler.getId());
			return "success";
		}
		return "error";
	}
}
