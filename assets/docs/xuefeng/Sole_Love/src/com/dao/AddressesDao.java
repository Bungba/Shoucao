package com.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

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
	 * ȡ�õ�ǰ�û������͵�ַ�б�
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	public List<Addresses> findAddInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Addresses where uid=? order by usecount desc");// ��ʹ�ô����Ӹߵ���
		query.setInteger(0, userid);
		List<Addresses> list = query.list();
		return list;
	}

	/**
	 * ������͵�ַ
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
					.createQuery("from Addresses where uid=? order by usecount desc");// ��ʹ�ô����Ӹߵ���
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		}
		return null;
	}

	/**
	 * �޸����͵�ַ
	 * 
	 * @param userid
	 * @param addresses
	 * @return
	 */
	@Transactional
	public List<Addresses> updateAddressInfo(int userid, Addresses addresses) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(addresses);
			Query query = session
					.createQuery("from Addresses where uid=? order by usecount desc");// ��ʹ�ô����Ӹߵ���
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		} catch (HibernateException e) {
			return null;
		}
	}
	/**
	 * �޸����͵�ַ
	 * 
	 * @param userid
	 * @param addresses
	 * @return
	 */
	@Transactional
	public List<Addresses> delAddressInfo(int userid, Addresses addresses) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(addresses);
			Query query = session
					.createQuery("from Addresses where uid=? order by usecount desc");// ��ʹ�ô����Ӹߵ���
			query.setInteger(0, userid);
			List<Addresses> list = query.list();
			return list;
		} catch (HibernateException e) {
			return null;
		}
	}
}
