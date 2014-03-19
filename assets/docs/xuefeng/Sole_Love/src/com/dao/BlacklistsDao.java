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
			//System.out.println(b.getCount());
			int i = b.getCount();
			//System.out.println(b.getIp());
			b.setCount(++i);
			//System.out.println(b.getCount());
			b.setCreationtime(new Timestamp(System.currentTimeMillis()));
			b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.update(b);
			return b;
		} /*
		 * else { b.setCount(0); b.setCreationtime(new
		 * Timestamp(System.currentTimeMillis())); b.setUpdatetime(new
		 * Timestamp(System.currentTimeMillis())); session.save(b); return b; }
		 */
		return null;
	}

	/**
	 * 错误次数清零
	 * 
	 * @param ip
	 */
	@Transactional
	public void clearErrCount(String ip) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b = (Blacklists) query.uniqueResult();
		//System.out.println("clearErrCount------------------");
		if (b != null) {
			//System.out.println("clearErrCount------------------00000000");
			b.setCount(0);
			b.setCreationtime(new Timestamp(System.currentTimeMillis()));
			b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.update(b);
		}
	}

	@Transactional
	public Blacklists findBlacklistsInfo(String ip) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b = (Blacklists) query.uniqueResult();
		return b;
	}
}
