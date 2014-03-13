package com.service;

import java.util.List;

import javax.annotation.Resource;

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
}
