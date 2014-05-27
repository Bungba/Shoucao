package com.service;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.SalerlevelsDao;
import com.model.Salerlevels;

@Service
public class SalerlevelsService {

	@Resource
	SalerlevelsDao salerlevelsDao;
	
	public Salerlevels findSalerlevelsInfo() {
		return salerlevelsDao.findSalerlevelsInfo();
	}
	public Salerlevels userSalerLevel(int userid){
		return salerlevelsDao.userSalerLevel(userid);
	}
}
