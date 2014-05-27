package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Repository;

import com.dao.ExpressDao;
import com.model.Expresses;

@Repository
public class ExpressService {
	@Resource
	ExpressDao expressDao;

	public List<Expresses> findExpInfo() {
		return expressDao.findExpInfo();
	}
}
