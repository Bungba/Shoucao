package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DiscountsDao;
import com.model.Discounts;

@Service
public class DiscountsService {

	@Resource
	DiscountsDao discountsDao;

	public Discounts findDisInfo(int salerid) {
		return discountsDao.findDisInfo(salerid);
	}
}
