package com.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Users;

@Repository
public class UsersDao {
	/**
	 * ��ѯUsers����
	 */
	@Resource
	SessionFactory sessionFactory;

	@Transactional
	public List<Users> findUsersInfo() {
		Session session = sessionFactory.getCurrentSession();// ���session
		Query query = session.createQuery("from Users");// ��ѯUsers����
		List<Users> list = query.list();
		// System.out.println(list.get(0).getEmail());
		return list;
	}

	/**
	 * �û�ע��
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
	 * ��֤�ֻ����������Ƿ����
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
	 * �û���¼
	 */
	@Transactional
	public Users login(String mobile, String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (mobile != null) {
			query = session
					.createQuery("from Users where mobile=? and password=?");
			query.setString(0, mobile);
			query.setString(1, password);
			return (Users) query.uniqueResult();
		} else if (email != null) {
			query = session
					.createQuery("from Users where email=? and password=?");
			query.setString(0, email);
			query.setString(1, password);
			return (Users) query.uniqueResult();
		}
		return null;
	}
	/**
	 * ע���ײ�ʹ������û�����Ϣ
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
}
