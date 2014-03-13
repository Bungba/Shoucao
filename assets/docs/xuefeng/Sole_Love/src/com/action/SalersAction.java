package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.SalersDao;

@Controller
@Scope("prototype")
public class SalersAction {

	@Resource
	SalersDao salersDao;

	public String findSalersInfo() {
		
		return "success";
	}

	public SalersDao getSalersDao() {
		return salersDao;
	}

	public void setSalersDao(SalersDao salersDao) {
		this.salersDao = salersDao;
	}
}
