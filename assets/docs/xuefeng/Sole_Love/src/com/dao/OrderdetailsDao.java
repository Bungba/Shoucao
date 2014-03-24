package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.FindOrder;
import com.model.Orderdetails;
import com.model.Orders;
import com.model.Products;
import com.model.Users;

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
				Integer sb = (Integer) session.save(orderdetails);
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
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Transactional
	public JSONArray findOrderdetailsInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		/*
		 * StringBuilder sb = new StringBuilder();
		 * sb.append("SELECT o.city,o.address,");
		 * sb.append(" o.code,o.discount,"); sb.append(" o.message,o.express,");
		 * sb.append(" o.express_fee,o.returned,"); sb.append(" os.count,");
		 * sb.append(" p.title,p.des,p.thumbnail,");
		 * sb.append(" p.price,p.image");
		 * sb.append(" FROM users u,orders o, Orderdetails os,products p");
		 * sb.append(" WHERE u.id=o.uid"); sb.append(" AND o.id=os.oid");
		 * sb.append(" AND os.pid=p.id"); sb.append(" AND u.id=?");
		 */
		Query query = session
				.createQuery("FROM Users u,Orders o, Orderdetails os,Products p WHERE u.id=o.uid AND o.id=os.oid AND os.pid=p.id AND u.id=?");
		query.setInteger(0, userid);
		ArrayList list = (ArrayList) query.list();
		Iterator iterator = list.iterator();
		if (iterator.hasNext()) {
			// Object[] o = (Object[]) iterator.next();
			// System.out.println((Users)o[0]);
			JSONArray ja=JSONArray.fromObject(list);
			return ja;
		}
		// System.out.println(jo.toString());
		return null;
	}
}
