package com.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Messages;
import com.model.Users;
import com.service.MessagesService;

@Controller
@Scope("prototype")
public class MessagesAction {

	@Resource
	MessagesService messagesService;

	// 返回数据
	private String result;
	private String error;

	/**
	 * 查询站内信
	 * 
	 * @return
	 */
	public String findMsgInfo() {
		
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute(
				"User");
		if (user != null) {
			List<Messages> list = messagesService.findMsgInfo(user.getId());
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"用户未登录\"}";
		return "success";
	}

	/**
	 * 读站内信
	 * 
	 * @return
	 */
	int msgId;// 站内信ID

	public String readMesInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute(
				"User");
		if (user != null) {
			List<Messages> list = messagesService.readMesInfo(user.getId(),
					msgId);
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"用户未登录\"}";
		return "success";
	}

	/**
	 * 新建站内信
	 * 
	 * @return
	 */
	public String addMsgInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute(
				"User");
		if (user != null) {
			Messages messages = new Messages();
			messages.setUid(user.getId());
			messagesService.addMsgInfo(messages);
			return "success";
		}
		return "error";
	}

	/**
	 * 删除站内信
	 * 
	 * @return
	 */
	int[] id;

	public String delMsgInfo() {
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute(
				"User");
		if (user != null) {
			List<Messages> list = messagesService.delMsgInfo(id, user.getId());
			JSONArray ja = JSONArray.fromObject(list);
			result = ja.toString();
			error = "{\"message\":\"无错误\"}";
			return "success";
		}
		error = "{\"message\":\"用户未登录\"}";
		return "success";
	}

	public MessagesService getMessagesService() {
		return messagesService;
	}

	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
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
