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
	 * ȡ�õ�ǰ�û������͵�ַ�б�
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
	 * ������͵�ַ
	 * @return
	 */
	public String addAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
				addressesService.addAddressInfo(user.getId(), addresses);
				return "success";
			//}
		}
		return "error";
	}
	/**
	 * �޸����͵�ַ
	 * @return
	 */
	public String updateAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
				addressesService.updateAddressInfo(user.getId(), addresses);
				return "success";
			//}
		}
		return "error";
	}
	/**
	 * ɾ�����͵�ַ
	 * @return
	 */
	public String delAddressInfo(){
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			//if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
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
