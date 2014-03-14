package com.action;

import java.awt.Graphics;
import java.io.ByteArrayInputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Salers;
import com.model.Users;
import com.service.SalersService;
import com.service.UsersService;
import com.util.MD5Util;
import com.util.RandomNumUtil;

@Controller
@Scope("prototype")
public class LoginAction {

	@Resource
	UsersService usersService;
	@Resource
	SalersService salersService;

	String mobile;// 手机号
	String email;// 邮箱
	String password;// 密码

	/**
	 * 验证手机或者邮箱是否存在
	 * 
	 * @param mobile
	 * @param email
	 * @return
	 */
	public String check_email_or_mobile_existed(String mobile, String email) {
		usersService.check_email_or_mobile_existed(mobile, email);
		return null;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */

	public String login() {
		Users users = null;
		MD5Util md5 = new MD5Util();
		String md = md5.string2MD5(password);
		if (mobile != null && password != null) {
			users = usersService.login(mobile, null, md);
		} else if (email != null && password != null) {
			users = usersService.login(null, email, md);
		}
		Salers salers = salersService.findSalersInfo(users.getId());// 首草使者信息

		ServletActionContext.getRequest().getSession().setAttribute("User", "");
		return null;
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String logOut() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			ServletActionContext.getRequest().getSession()
					.removeAttribute("User");// 将session中的用户信息清除
			return "success";
		}
		return "error";
	}

	/**
	 * 验证码
	 * 
	 * @return
	 */
	private ByteArrayInputStream inputStream;

	public String identifieCode() {
		RandomNumUtil rdnu = RandomNumUtil.Instance();
		this.setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
		ServletActionContext.getRequest().getSession()
				.setAttribute("identifie", rdnu.getString());// 取得随机字符串放入Session
		return "success";
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SalersService getSalersService() {
		return salersService;
	}

	public void setSalersService(SalersService salersService) {
		this.salersService = salersService;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

}
