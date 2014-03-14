package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Greetings;
import com.model.Users;
import com.service.GreetingsService;

@Controller
@Scope("prototype")
public class GreetingsAction {

	@Resource
	GreetingsService greetingsService;

	/**
	 * ��ǰ�û�ʹ�ù���ף��
	 * 
	 * @return
	 */
	public String findGreetingInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");// ȡ��session�еĵ�ǰ�û�
		// greetingsService.findGreetingsInfo(user.getId());
		if (user != null) {
			List<Greetings> list = greetingsService.findGreetingsInfo(user
					.getId());
			return "success";
		}
		return "error";
	}

	/**
	 * �½�ף��
	 */
	String char_id;
	String bg_id;
	String sound;

	public String addGreetingInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (user != null && char_id != null && bg_id != null && sound != null) {
			greetingsService.addGreetingInfo(user.getId(), char_id, bg_id,
					sound);
			return "success";
		}
		return "error";
	}

	public GreetingsService getGreetingsService() {
		return greetingsService;
	}

	public void setGreetingsService(GreetingsService greetingsService) {
		this.greetingsService = greetingsService;
	}

	public String getChar_id() {
		return char_id;
	}

	public void setChar_id(String char_id) {
		this.char_id = char_id;
	}

	public String getBg_id() {
		return bg_id;
	}

	public void setBg_id(String bg_id) {
		this.bg_id = bg_id;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}
