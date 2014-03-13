package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Users;
import com.service.GreetingsService;

@Controller
@Scope("prototype")
public class GreetingsAction {

	@Resource
	GreetingsService greetingsService;

	public String findGreetingInfo() {
		/*Users users = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("Users");
		greetingsService.findGreetingsInfo(users.getId());*/
		greetingsService.findGreetingsInfo(1);
		return "success";
	}
}
