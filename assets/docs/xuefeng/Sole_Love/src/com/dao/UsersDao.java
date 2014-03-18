package com.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
	public List<Users> findUsersInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();// 获得session
		Query query = session.createQuery("from Users where id=?");// 查询Users数据
		query.setInteger(0, userid);
		List<Users> list = query.list();
		// System.out.println(list.get(0).getEmail());
		return list;
	}

	/**
	 * 用户注册
	 */
	@Transactional
	public Users addUserInfo(Users users) {
		Session session = sessionFactory.getCurrentSession();
		Serializable serializable = session.save(users);
		if (serializable != null) {
			return users;
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
	public boolean check_email_or_mobile_existed(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Users where mobile=? or email=?");
		query.setString(0, mobile);
		query.setString(1, email);
		Users users = (Users) query.uniqueResult();
		if (users != null) {
			return true;
		}
		return false;
	}

	/**
	 * 用户登录
	 */
	@Transactional
	public Users login(String ip,String mobile, String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		query=session.createQuery("from Blacklists where ip=?");
		query.setString(0, ip);
		Blacklists b=(Blacklists)query.uniqueResult();
		if (b==null||b.getCount()<10) {
			if (mobile != null) {
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
				return (Users) query.uniqueResult();
			}
		}
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
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void unlock(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session
					.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users=(Users)query.uniqueResult();
			users.setLocked(0);
			session.update(users);
		} else if (email != null) {
			query = session
					.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users=(Users)query.uniqueResult();
			users.setLocked(0);
			session.update(users);
		}
	}
	/**
	 * 登陆锁定
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void locked(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session
					.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users=(Users)query.uniqueResult();
			users.setLocked(1);
			session.update(users);
		} else if (email != null) {
			query = session
					.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users=(Users)query.uniqueResult();
			users.setLocked(1);
			session.update(users);
		}
	}
	/**
	 * 账号永久锁定
	 * @param mobile
	 * @param email
	 */
	@Transactional
	public void lockedDel(String mobile, String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session
					.createQuery("from Users where mobile=?");
			query.setString(0, mobile);
			Users users=(Users)query.uniqueResult();
			users.setDelFlag(1);
			session.update(users);
		} else if (email != null) {
			query = session
					.createQuery("from Users where email=?");
			query.setString(0, email);
			Users users=(Users)query.uniqueResult();
			users.setDelFlag(1);
			session.update(users);
		}
	}
}
