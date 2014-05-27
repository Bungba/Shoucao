package com.dao;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Invcodes;

@Repository
public class InvcodesDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 查询邀请码是否使用
	 * 
	 * @param invcodes
	 * @return
	 */
	@Transactional
	public boolean findInvcodesInfo(String invcodes) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Invcodes where code=?");
		query.setString(0, invcodes);
		Invcodes invcodes2 = (Invcodes) query.uniqueResult();
		if (invcodes2.getSid() == 0 && invcodes2.getSid() != null) {
			return true;
		}
		return false;
	}
}
