package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Salers;

@Repository
public class SalersDao {
	/**
	 * 根据用户ID查询首草使者信息
	 */
	@Resource
	SessionFactory sessionFactory;

	@Transactional
	public Salers findSalersInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Salers where uid=?");
		query.setInteger(0, userid);
		Salers salers = (Salers) query.uniqueResult();
		if (salers!=null) 
			return salers;
		else
			return null;
		
	}
}
