package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Invcodes;
import com.service.InvcodesService;

@Controller
@Scope("prototype")
public class InvcodesAction {

	@Resource
	InvcodesService invcodesService;

	/**
	 * ��ѯ�������Ƿ�ʹ��
	 * 
	 * @return
	 */
	String invcodes;

	public String findInvcodesInfo() {
		if (invcodesService.findInvcodesInfo(invcodes)) {
			return "success";
		} else {
			return "error";
		}

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
}
