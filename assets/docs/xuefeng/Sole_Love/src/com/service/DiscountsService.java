package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.DiscountsDao;
import com.model.Discounts;

@Service
public class DiscountsService {

	@Resource
	DiscountsDao discountsDao;

	public List<Discounts> findMonthDisInfo(int salerid,String month) {
		return discountsDao.findMonthDisInfo(salerid,month);
	}
	public List<Discounts> findYearDisInfo(int salerid,String year) {
		return discountsDao.findYearDisInfo(salerid, year);
	}
	public List findMonthOrders(String year,String month){
		return discountsDao.findMonthOrders(year, month);
	}
}
