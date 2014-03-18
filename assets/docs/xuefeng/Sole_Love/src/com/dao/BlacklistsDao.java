package com.dao;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Blacklists;

@Repository
public class BlacklistsDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 记录登陆错误次数
	 * 
	 * @param ip
	 * @return
	 */
	@Transactional
	public Blacklists logErrCount(String ip) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b = (Blacklists) query.uniqueResult();
		if (b != null) {
			System.out.println(b.getIp());
			b.setCount(b.getCount() + 1);
			b.setCreationtime(new Timestamp(System.currentTimeMillis()));
			b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.update(b);
			return b;
		} else {
			b.setCount(0);
			b.setCreationtime(new Timestamp(System.currentTimeMillis()));
			b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.save(b);
			return b;
		}
	}

	/**
	 * 错误次数清零
	 * @param ip
	 */
	@Transactional
	public void clearErrCount(String ip) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b = (Blacklists) query.uniqueResult();
		if (b != null) {
			b.setCount(0);
			b.setCreationtime(new Timestamp(System.currentTimeMillis()));
			b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.update(b);
		}
	}
}
