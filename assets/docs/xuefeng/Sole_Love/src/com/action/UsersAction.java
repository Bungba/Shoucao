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

	int userid;

	/**
	 * 查询用户信息
	 * 
	 * @return
	 */
	public String findUsersInfo() {
		usersService.findUsersInfo();
		if (userid != 0) {
			salersService.findSalersInfo(userid);
		}
		return "success";
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
			// users.setPassword(md5.string2MD5(password));
			ServletActionContext.getRequest().getSession()
					.setAttribute("User", usersService.addUserInfo(users));// 用户信息存session
		}
		return null;
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String logOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("User");// 将session中的用户信息清除
		return "success";
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
