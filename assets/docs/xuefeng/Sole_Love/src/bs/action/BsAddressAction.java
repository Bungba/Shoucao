package bs.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Addresses;
import com.model.Users;

import bs.service.BsAddressService;

@Controller
@Scope("prototype")
public class BsAddressAction {
	@Resource
	BsAddressService bsAddressService;

	String result;

	public String wxAddress() {
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (u != null) {
			List<Addresses> list = bsAddressService.findAddressInfo(u.getId());
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
		} else {
			result = "[{\"message\":\"ÇëµÇÂ¼\"}]";
		}

		return "success";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
