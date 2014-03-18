package com.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Infos;

@Repository
public class InfosDao {

	@Resource
	SessionFactory sessionFactory;
	
	/**
	 * 优惠代码验证
	 * @param verify
	 * @return
	 */
	@Transactional
	public Infos checkVerify(String verify){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Infos where key=?");
		query.setString(0, verify);
		Infos infos=(Infos)query.uniqueResult();
		if (infos!=null) {
			return infos;
		}
		return null;
	}
}
