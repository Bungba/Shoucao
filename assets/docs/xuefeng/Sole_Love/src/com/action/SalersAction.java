package com.action;

import javax.annotation.Resource;
import javax.crypto.spec.IvParameterSpec;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.SalersDao;
import com.model.Salers;
import com.model.Users;
import com.service.InvcodesService;
import com.service.SalersService;
import com.service.UsersService;

@Controller
@Scope("prototype")
public class SalersAction {

	@Resource
	SalersService salersService;
	@Resource
	InvcodesService invcodesService;
	@Resource
	UsersService usersService;

	/**
	 * 首草使者信息
	 * 
	 * @return
	 */
	public String findSalersInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			Salers salers = salersService.findSalersInfo(user.getId());
			return "success";
		}
		return "error";
	}

	/**
	 * 查询邀请码是否使用
	 * 
	 * @return
	 */
	String invcodes;// 邀请码
	public String findInvcodesInfo() {
		if (invcodesService.findInvcodesInfo(invcodes)) {
			return "success";
		}
		return "error";
	}

	/**
	 * 注册首草使者
	 * 
	 * @return
	 */
	
	String idcode;// 身份证
	String tel;// 联系方式
	String address;// 地址

	public String addSalersInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			salersService.addSalersInfo(user.getId(),  idcode,invcodes);
			user = usersService.updateUserInfo(user.getId(), tel, address);
			ServletActionContext.getRequest().getSession()
					.removeAttribute("User");
			ServletActionContext.getRequest().getSession()
					.setAttribute("User", user);
			return "success";
		}

		return "error";
	}

	public SalersService getSalersService() {
		return salersService;
	}

	public void setSalersService(SalersService salersService) {
		this.salersService = salersService;
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

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

}
