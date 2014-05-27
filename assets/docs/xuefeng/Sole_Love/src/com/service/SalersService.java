package com.service;


import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.SalersDao;
import com.model.Salers;

@Service
public class SalersService {
	@Resource
	SalersDao salersDao;

	public Salers findSalersInfo(int userid) {
		return salersDao.findSalersInfo(userid);
	}

	public Salers addSalersInfo(int userid,  String idcode,String invcodes) {
		return salersDao.addSalersInfo(userid, idcode,invcodes);
	}
	public boolean findInvcodesInfo(String invcodes) {
		return salersDao.findInvcodesInfo(invcodes);
	}
}
