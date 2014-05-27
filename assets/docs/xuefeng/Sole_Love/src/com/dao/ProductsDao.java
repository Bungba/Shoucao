package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Orderdetails;
import com.model.Products;

@Repository
public class ProductsDao {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 所有产品列表
	 * 
	 * @return
	 */
	@Transactional
	public List<Products> findProductsInfo() {
		Session session = sessionFactory.getCurrentSession();// 获得session
		Query query = session.createQuery("from Products");// 查询Products数据
		List<Products> list = query.list();// 添加list集合
		return list;
	}

	/**
	 * 当前用户订单所购买产品
	 */
	@Transactional
	public List<Products> findProductsInfo(List<Orderdetails> detailsList) {
		Session session = sessionFactory.getCurrentSession();// 获得session
		List<Products> list = new ArrayList<Products>();
		Query query = null;
		for (int i = 0; i < detailsList.size(); i++) {
			query = session.createQuery("from Products where id=?");// 查询Products数据
			query.setInteger(0, detailsList.get(i).getId());
			list.add((Products) query.uniqueResult());
		}
		if (list.size() != 0) {
			return list;
		}
		return list;
	}
}
