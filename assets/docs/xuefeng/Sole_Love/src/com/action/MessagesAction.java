package com.action;

import javax.annotation.Resource;

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

	/**
	 * 查询站内信
	 * 
	 * @return
	 */
	public String findMsgInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			messagesService.findMsgInfo(user.getId());
			return "success";
		}
		return "error";
	}

	/**
	 * 读站内信
	 * 
	 * @return
	 */
	int msgId;// 站内信ID

	public String readMesInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			messagesService.readMesInfo(user.getId(), msgId);
			return "success";
		}
		return "error";
	}

	/**
	 * 新建站内信
	 * 
	 * @return
	 */
	public String addMsgInfo() {
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
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
		Users user = (Users) ServletActionContext.getRequest().getAttribute(
				"User");
		if (user != null) {
			messagesService.delMsgInfo(id, user.getId());
			return "success";
		}
		return "erro";
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
}
