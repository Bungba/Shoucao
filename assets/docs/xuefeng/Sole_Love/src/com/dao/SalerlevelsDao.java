package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Salerlevels;

@Repository
public class SalerlevelsDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 使者等级机制
	 */
	@Transactional
	public Salerlevels findSalerlevelsInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Salerlevels");
		Salerlevels sl = (Salerlevels) query.uniqueResult();
		return sl;
	}

	/**
	 * 当前用户使者等级 
	 * 1.根据订单查出销售额(没有退货，已付款)
	 *  2.根据销售额得出当前用户的使者等级
	 */
	@Transactional
	public Salerlevels userSalerLevel(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		query = session
				.createSQLQuery("select SUM(price) FROM orders o,orderdetails od WHERE o.id=od.oid AND uid =? AND paied =0 AND returned=0");
		query.setInteger(0, userid);
		Double saleroom = (Double) query.uniqueResult();

		query = session
				.createSQLQuery("SELECT MAX(saleroom) FROM salerlevels WHERE saleroom <=?");
		query.setDouble(0, saleroom);
		Double s = (Double) query.uniqueResult();
		query = session.createQuery("FROM Salerlevels WHERE saleroom=?");
		query.setDouble(0, s);
		Salerlevels sl = (Salerlevels) query.uniqueResult();
		if (sl != null) {
			return sl;
		}
		return null;
	}
}
