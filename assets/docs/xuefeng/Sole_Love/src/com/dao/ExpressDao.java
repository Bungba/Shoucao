package com.dao;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Expresses;

@Repository
public class ExpressDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 取得快递列表
	 * 
	 * @return
	 */
	@Transactional
	public List<Expresses> findExpInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Expresses");
		List<Expresses> list = query.list();
		return list;
	}
}
