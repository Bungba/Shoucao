package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Users;
import com.service.SalersService;
import com.service.UsersService;
import com.util.MD5Util;

@Controller
@Scope("prototype")
public class UsersAction {

	@Resource
	UsersService usersService;
	@Resource
	SalersService salersService;

	/**
	 * 查询用户信息
	 * 
	 * @return
	 */
	public String findUsersInfo() {

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			usersService.findUsersInfo(user.getId());
			salersService.findSalersInfo(user.getId());
			return "success";
		}
		return "error";
	}

	/**
	 * 注册新用户
	 * 
	 * @return
	 */
	String name;
	String password;
	String rand;

	public String addUserInfo() {
		Users users = new Users();
		users.setNickname(name);
		MD5Util md5 = new MD5Util();

		String arandom = (String) (ServletActionContext.getRequest()
				.getSession().getAttribute("identifie"));
		// 将session中保存验证码字符串与客户输入的验证码字符串对比了
		if (arandom.equals(this.getRand())) {
			users.setPassword(md5.string2MD5(password));
			ServletActionContext.getRequest().getSession()
					.setAttribute("User", usersService.addUserInfo(users));// 用户信息存session
		}
		return null;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public SalersService getSalersService() {
		return salersService;
	}

	public void setSalersService(SalersService salersService) {
		this.salersService = salersService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

}
