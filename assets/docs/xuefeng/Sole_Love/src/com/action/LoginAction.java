package com.action;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Blacklists;
import com.model.Salers;
import com.model.Users;
import com.service.BlacklistsService;
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
	@Resource
	BlacklistsService blacklistsService;

	// 返回数据
	private String result;
	private String error;

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
	public String check_email_or_mobile_existed() {
		// System.out.println(mobile+"    "+email);
		boolean bool = usersService
				.check_email_or_mobile_existed(mobile, email);
		if (bool) {
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"手机或者邮箱已存在\"}";
		return "success";
	}

	/**
	 * 登录
	 * 
	 * @return
	 */

	public String login() {
		Users users = null;
		MD5Util md5 = new MD5Util();
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		Blacklists blacklists = blacklistsService.findBlacklistsInfo(ip);
		String md = md5.string2MD5(password);
		// System.out.println(blacklists.getCount()+"    "+mobile+"   "+password);
		if (blacklists.getCount() >= 3) {
			// System.out.println("blacklists.getCount() == 3");
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
			String f = df.format(new Date());
			String l = df.format(blacklists.getUpdatetime().getTime() + 600000);
			usersService.locked(mobile, email);// 锁定账号
			if (Double.parseDouble(f) > Double.parseDouble(l)) {
				usersService.unlock(mobile, email);// 解锁账号
				if (mobile != null && password != null) {
					users = usersService.login(ip, mobile, null, md);// 用户信息
				} else if (email != null && password != null) {
					users = usersService.login(ip, null, email, md);
				}
				if (users != null) {
					Salers salers = salersService.findSalersInfo(users.getId());// 首草使者信息
					ServletActionContext.getRequest().getSession()
							.setAttribute("User", users);
					ServletActionContext.getRequest().getSession()
							.setAttribute("Saler", salers);
					usersService.loginDate(mobile, email);// 登陆日期
					blacklistsService.clearErrCount(ip);// 登陆错误次数清零
					JSONArray ja = new JSONArray();
					ja.add(users);
					ja.add(salers);
					result = ja.toString();
					return "success";
				} else if (users == null) {
					blacklistsService.logErrCount(ip);
					error = "{\"message\":\"用户名或者密码不正确\"}";
					return "success";
				}
			}
			error = "{\"message\":\"账号已锁定,10分钟内不可登录\"}";
			return "success";
		} else if (blacklists.getCount() >= 10) {
			error = "{\"message\":\"IP地址已被Block\"}";
			return "success";
		} else {
			if (mobile != null && password != null) {
				users = usersService.login(ip, mobile, null, md);// 用户信息
			} else if (email != null && password != null) {
				users = usersService.login(ip, null, email, md);
			}
			if (users != null) {
				Salers salers = salersService.findSalersInfo(users.getId());// 首草使者信息
				ServletActionContext.getRequest().getSession()
						.setAttribute("User", users);
				ServletActionContext.getRequest().getSession()
						.setAttribute("Saler", salers);
				usersService.loginDate(mobile, email);// 登陆日期
				blacklistsService.clearErrCount(ip);// 登陆错误次数清零
				JSONArray ja = new JSONArray();
				ja.add(users);
				ja.add(salers);
				result = ja.toString();
				return "success";
			} else if (users == null) {
				blacklistsService.logErrCount(ip);
				error = "{\"message\":\"用户名或者密码不正确\"}";
				return "success";
			}
		}
		return "success";
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

	public BlacklistsService getBlacklistsService() {
		return blacklistsService;
	}

	public void setBlacklistsService(BlacklistsService blacklistsService) {
		this.blacklistsService = blacklistsService;
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
