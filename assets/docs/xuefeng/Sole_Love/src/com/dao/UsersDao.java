package com.dao;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Blacklists;
import com.model.Users;

@Repository
public class UsersDao {
	/**
	 * 查询Users数据
	 */
	@Resource
	SessionFactory sessionFactory;

	@Transactional
	public Users findUsersInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();// 获得session
		Query query = session.createQuery("from Users where id=?");// 查询Users数据
		query.setInteger(0, userid);
		Users list = (Users) query.uniqueResult();
		// System.out.println(list.get(0).getEmail());
		return list;
	}

	/**
	 * 用户注册
	 */
	@Transactional
	public Users addUserInfo(Users users, String ip) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		Integer y = (Integer) session.save(users);
		if (y != 0) {
			query = session.createQuery("from Blacklists where ip=?");
			query.setString(0, ip);
			Blacklists bk = (Blacklists) query.uniqueResult();
			if (bk.getId() == null) {
				Blacklists b = new Blacklists();
				b.setIp(ip);
				b.setCount(0);
				b.setCreationtime(new Timestamp(System.currentTimeMillis()));
				b.setUpdatetime(new Timestamp(System.currentTimeMillis()));
				session.save(b);
			}
			query = session.createQuery("from Users where id=?");
			query.setInteger(0, y);
			return (Users) query.uniqueResult();
		}
		return null;
	}

	/**
	 * 验证手机或者邮箱是否存在
	 * 
	 * @param mobile
	 * @param email
	 * @return
	 */
	@Transactional
	public boolean check_email_or_mobile_existed(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Users where mobile=? or email=?");
		query.setString(0, mobile);
		query.setString(1, email);
		Users users = (Users) query.uniqueResult();
		if (users != null) {
			return false;
		}
		return true;
	}

	/**
	 * 用户登录
	 */
	@Transactional
	public Users login(String ip, String mobile, String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		query = session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b = (Blacklists) query.uniqueResult();
		// System.out.println(b.getIp()+"=============");
		if (b == null || b.getCount() < 10) {
			// System.out.println("b == null || b.getCount() < 10");
			if (mobile != null) {
				// System.out.println("mobile != null");
				// System.out.println(mobile+" "+password);
				query = session
						.createQuery("from Users where mobile=? and password=? and locked=0 and delflag=0");
				query.setString(0, mobile);
				query.setString(1, password);
				return (Users) query.uniqueResult();
			} else if (email != null) {
				query = session
						.createQuery("from Users where email=? and password=? and locked=0 and delflag=0");
				query.setString(0, email);
				query.setString(1, password);
				System.out.println("=================");
				return (Users) query.uniqueResult();
			}
		}
		System.out.println("----------------");
		return null;
	}

	/**
	 * 用户登录时间
	 */
	@Transactional
	public void loginDate(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		Users users = null;
		if (mobile != null) {
			query = session.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			users = (Users) query.uniqueResult();
			users.setLastlogintime(new Timestamp(System.currentTimeMillis()));
			session.update(users);
		} else if (email != null) {
			query = session.createQuery("from Users where email=?");
			query.setString(0, email);
			users = (Users) query.uniqueResult();
			users.setLastlogintime(new Timestamp(System.currentTimeMillis()));
			session.update(users);
		}
	}

	/**
	 * 注册首草使者添加用户新信息
	 * 
	 * @param userid
	 * @param tel
	 * @param address
	 * @return
	 */
	@Transactional
	public Users updateUserInfo(int userid, String tel, String address) {
		Session session = sessionFactory.getCurrentSession();
		Users u = new Users();
		u.setId(userid);
		u.setTel(tel);
		u.setAddress(address);
		session.update(u);
		Query query = session.createQuery("from Users where id=?");
		query.setInteger(0, userid);
		u = (Users) query.uniqueResult();
		return u;
	}

	/**
	 * 登陆解锁
	 * 
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void unlock(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users = (Users) query.uniqueResult();
			users.setLocked(0);
			session.update(users);
		} else if (email != null) {
			query = session.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users = (Users) query.uniqueResult();
			users.setLocked(0);
			session.update(users);
		}
	}

	/**
	 * 登陆锁定
	 * 
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void locked(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users = (Users) query.uniqueResult();
			users.setLocked(1);
			session.update(users);
		} else if (email != null) {
			query = session.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users = (Users) query.uniqueResult();
			users.setLocked(1);
			session.update(users);
		}
	}

	/**
	 * 账号永久锁定
	 * 
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void lockedDel(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users = (Users) query.uniqueResult();
			users.setDelFlag(1);
			session.update(users);
		} else if (email != null) {
			query = session.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users = (Users) query.uniqueResult();
			users.setDelFlag(1);
			session.update(users);
		}
	}
}
