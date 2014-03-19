package com.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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

	// ��������
	private String result;
	private String error;

	/**
	 * ȡ�õ�ǰ�û������͵�ַ�б�
	 * 
	 * @return
	 */
	public String findAddInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			List<Addresses> list = addressesService.findAddInfo(user.getId());
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
	}

	Addresses addresses;

	/**
	 * ������͵�ַ
	 * 
	 * @return
	 */
	public String addAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			// if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
			List<Addresses> list = addressesService.addAddressInfo(
					user.getId(), addresses);
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
			// }
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
	}

	/**
	 * �޸����͵�ַ
	 * 
	 * @return
	 */
	public String updateAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			// if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
			List<Addresses> list=addressesService.updateAddressInfo(user.getId(), addresses);
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
			// }
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
	}

	/**
	 * ɾ�����͵�ַ
	 * 
	 * @return
	 */
	int addressId;

	public String delAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			// if (addresses) {//�жϲ����Ƿ�ȱʧ����������ʽ�Ƿ���ȷ
			List<Addresses> list=addressesService.delAddressInfo(user.getId(), addressId);
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"�޴���\"}";
			return "success";
			// }
		}
		error = "{\"message\":\"�û�δ��¼\"}";
		return "success";
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

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
