package com.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Addresses;

@Repository
public class AddressesDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 取得当前用户的配送地址列表
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	public List<Addresses> findAddInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Addresses where uid=? order by usecount desc");// 以使用次数从高到低
		query.setInteger(0, userid);
		List<Addresses> list = query.list();
		return list;
	}

	/**
	 * 添加配送地址
	 * 
	 * @param userid
	 * @param addresses
	 * @return
	 */
	@Transactional
	public List<Addresses> addAddressInfo(int userid, Addresses addresses) {
		Session session = sessionFactory.getCurrentSession();
		Serializable sb = session.save(addresses);
		if (sb != null) {
			Query query = session
					.createQuery("from Addresses where uid=? order by usecount desc");// 以使用次数从高到低
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		}
		return null;
	}

	/**
	 * 修改配送地址
	 * 
	 * @param userid
	 * @param addresses
	 * @return
	 */
	@Transactional
	public List<Addresses> updateAddressInfo(int userid, Addresses addresses) {
		Session session = sessionFactory.getCurrentSession();
		Query query =null;
		try {
			session.update(addresses);
			session.flush();
			query =session
					.createQuery("from Addresses where uid=? order by usecount desc");// 以使用次数从高到低
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		} catch (HibernateException e) {
			return null;
		}
	}
	/**
	 * 删除配送地址
	 * 
	 * @param userid
	 * @param addresses
	 * @return
	 */
	@Transactional
	public List<Addresses> delAddressInfo(int userid, int addressId) {
		Session session = sessionFactory.getCurrentSession();
		Query query=null;
		try {
			query=session.createQuery("from Addresses where id=?");
			query.setInteger(0, addressId);
			Addresses ads=(Addresses) query.uniqueResult();
			session.delete(ads);
			session.flush();
			query = session
					.createQuery("from Addresses where uid=? order by usecount desc");// 以使用次数从高到低
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		} catch (HibernateException e) {
			return null;
		}
	}
}
