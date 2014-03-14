package com.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Addresses;
import com.model.Users;
import com.service.AddressesService;

@Controller
@Scope("prototype")
public class AddressAction {
	@Resource
	AddressesService addressesService;

	/**
	 * 取得当前用户的配送地址列表
	 * 
	 * @return
	 */
	public String findAddInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			addressesService.findAddInfo(user.getId());
			return "success";
		}
		return "error";
	}
	
	Addresses addresses;
	/**
	 * 添加配送地址
	 * @return
	 */
	public String addAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//判断参数是否缺失、检查参数格式是否正确
				addressesService.addAddressInfo(user.getId(), addresses);
				return "success";
			//}
		}
		return "error";
	}
	/**
	 * 修改配送地址
	 * @return
	 */
	public String updateAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//判断参数是否缺失、检查参数格式是否正确
				addressesService.updateAddressInfo(user.getId(), addresses);
				return "success";
			//}
		}
		return "error";
	}
	/**
	 * 删除配送地址
	 * @return
	 */
	public String delAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//判断参数是否缺失、检查参数格式是否正确
				addressesService.delAddressInfo(user.getId(), addresses);
				return "success";
			//}
		}
		return "error";
	}
	public AddressesService getAddressesService() {
		return addressesService;
	}

	public void setAddressesService(AddressesService addressesService) {
		this.addressesService = addressesService;
	}
	public Addresses getAddresses() {
		return addresses;
	}
	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

}
