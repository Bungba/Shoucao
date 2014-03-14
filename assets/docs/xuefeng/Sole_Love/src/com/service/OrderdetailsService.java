package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.OrderdetailsDao;
import com.model.Orderdetails;
import com.model.Orders;
import com.model.Products;

@Service
public class OrderdetailsService {

	@Resource
	OrderdetailsDao orderdetailsDao;

	public List<Orderdetails> addOrderdetailsInfo(int oid,
			List<Products> products, int count) {
		return orderdetailsDao.addOrderdetailsInfo(oid, products, count);
	}

	public List<Orderdetails> findOrderdetailsInfo(List<Orders> list) {
		return orderdetailsDao.findOrderdetailsInfo(list);
	}
}
