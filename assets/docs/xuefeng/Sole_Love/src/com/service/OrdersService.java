package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.OrdersDao;
import com.model.Orders;
import com.model.Products;

@Service
public class OrdersService {
	@Resource
	OrdersDao ordersDao;

	public Orders addOrdersInfo(Orders orders) {
		return ordersDao.addOrdersInfo(orders);
	}

	public List<Orders> findAllOrdersInfo(int userid) {
		return ordersDao.findAllOrdersInfo(userid);
	}
}
