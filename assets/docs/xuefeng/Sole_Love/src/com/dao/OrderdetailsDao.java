package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Orderdetails;
import com.model.Orders;
import com.model.Products;

@Repository
public class OrderdetailsDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 添加订单详情
	 * 
	 * @param oid
	 * @param products
	 * @return
	 */
	@Transactional
	public List<Orderdetails> addOrderdetailsInfo(int oid,
			List<Products> products, int count) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> id = new ArrayList<Integer>();
		if (oid != 0 && products.size() != 0 && count != 0) {
			for (int i = 0; i < products.size(); i++) {
				Orderdetails orderdetails = new Orderdetails();
				orderdetails.setOid(oid);
				orderdetails.setPid(products.get(i).getId());
				orderdetails.setPrice(products.get(i).getPrice());
				orderdetails.setCount(count);
				Integer sb =(Integer) session.save(orderdetails);
				id.add(sb);
			}
			return null;
		}

		if (id.size() != 0) {
			List<Orderdetails> list = new ArrayList<Orderdetails>();
			for (int i = 0; i < id.size(); i++) {
				Query query = session
						.createQuery("from Orderdetails where id=?");
				query.setInteger(0, id.get(i));
				list.add((Orderdetails) query.uniqueResult());
			}
			return list;
		}
		return null;
	}

	/**
	 * 当前用户订单详情
	 */
	@Transactional
	public List<Orderdetails> findOrderdetailsInfo(List<Orders> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Orderdetails> detailsList = new ArrayList<Orderdetails>();
		for (int i = 0; i < list.size(); i++) {
			Query query = session.createQuery("from Orderdetails where oid=?");
			query.setInteger(0, list.get(i).getId());
			detailsList.add((Orderdetails) query.uniqueResult());
		}
		if (detailsList.size() != 0) {
			return detailsList;
		}
		return null;
	}
}
