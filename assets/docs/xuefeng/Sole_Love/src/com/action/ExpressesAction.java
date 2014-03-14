package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Expresses;
import com.service.ExpressService;

@Controller
@Scope("prototype")
public class ExpressesAction {
	@Resource
	ExpressService expressService;

	/**
	 * ȡ�ÿ���б�
	 * 
	 * @return
	 */
	public String findExpressInfo() {
		List<Expresses> list = expressService.findExpInfo();
		return "success";
	}
}
