package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

	// 返回数据
	private String result;
	private String error;

	/**
	 * 取得当前用户的配送地址列表
	 * 
	 * @return
	 */
	public String findAddInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			List<Addresses> list = addressesService.findAddInfo(user.getId());
			JSONArray ja = JSONArray.fromObject(list);
			result=ja.toString();
			return "success";
		}
		result = "[{\"message\":\"用户未登录\"}]";
		return "success";
	}

	/**
	 * 添加配送地址
	 * 
	 * @return
	 */
	String name;
	String address;
	String city;
	String zip;
	String tel;

	public String addAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			// if (addresses) {//判断参数是否缺失、检查参数格式是否正确
			Addresses addresses = new Addresses();
			addresses.setUid(user.getId());
			addresses.setName(name);
			addresses.setAddress(address);
			addresses.setCity(city);
			addresses.setZip(zip);
			addresses.setTel(tel);
			addresses.setDelFlag(false);
			addresses.setUsecount(0);
			addresses
					.setCreationtime(new Timestamp(System.currentTimeMillis()));
			addresses.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			List<Addresses> list = addressesService.addAddressInfo(
					user.getId(), addresses);
			JSONArray ja = JSONArray.fromObject(list);
			StringBuffer sb=new StringBuffer();
			sb.append(ja.toString());
			sb.append("[{\"message\":\"无错误\"}]");
			result=sb.toString();
			return "success";
			// }
		}
		result = "[{\"message\":\"用户未登录\"}]";
		return "success";
	}

	/**
	 * 修改配送地址
	 * 
	 * @return
	 */
	String id;
	String count;
	boolean flag;

	public String updateAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			Addresses addresses = new Addresses();
			addresses.setUid(user.getId());
			addresses.setId(Integer.parseInt(id));
			addresses.setName(name);
			addresses.setAddress(address);
			addresses.setCity(city);
			addresses.setZip(zip);
			addresses.setTel(tel);
			addresses.setUsecount(Integer.parseInt(count));
			addresses.setDelFlag(flag);
			addresses.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			// if (addresses) {//判断参数是否缺失、检查参数格式是否正确
			List<Addresses> list = addressesService.updateAddressInfo(
					user.getId(), addresses);
			JSONArray ja = JSONArray.fromObject(list);
			StringBuffer sb=new StringBuffer();
			sb.append(ja.toString());
			sb.append("[{\"message\":\"无错误\"}]");
			result=sb.toString();
			return "success";
			// }
		}
		result = "[{\"message\":\"用户未登录\"}]";
		return "success";
	}

	/**
	 * 删除配送地址
	 * 
	 * @return
	 */

	public String delAddressInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null) {
			// if (addresses) {//判断参数是否缺失、检查参数格式是否正确
			//System.out.println(user.getId()+"----------------------"+id);
			List<Addresses> list = addressesService.delAddressInfo(
					user.getId(), Integer.parseInt(id));
			JSONArray ja = JSONArray.fromObject(list);
			StringBuffer sb=new StringBuffer();
			sb.append(ja.toString());
			sb.append("[{\"message\":\"无错误\"}]");
			result=sb.toString();
			return "success";
			// }
		}
		result = "[{\"message\":\"用户未登录\"}]";
		return "success";
	}

	public AddressesService getAddressesService() {
		return addressesService;
	}

	public void setAddressesService(AddressesService addressesService) {
		this.addressesService = addressesService;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
