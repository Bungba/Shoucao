package com.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Orders;
import com.model.Products;

@Repository
public class OrdersDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 添加订单
	 * 
	 * @param orders
	 * @return
	 */
	@Transactional
	public Orders addOrdersInfo(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		Integer sb = (Integer) session.save(orders);
		if (sb != null) {
			Query query = session.createQuery("from Orders where id=?");
			query.setInteger(0, sb);
			Orders orders2 =(Orders) query.uniqueResult();
			return orders2;
		}
		return null;
	}

	/**
	 * 取得用户所有订单
	 */
	@Transactional
	public List<Orders> findAllOrdersInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orders where uid=?");
		query.setInteger(0, userid);
		List<Orders> list = query.list();
		if (list != null) {
			return list;
		}
		return null;
	}
}
