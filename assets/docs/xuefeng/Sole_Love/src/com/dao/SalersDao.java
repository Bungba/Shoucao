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

import com.model.Invcodes;
import com.model.Salers;

@Repository
public class SalersDao {
	/**
	 * �����û�ID��ѯ�ײ�ʹ����Ϣ
	 */
	@Resource
	SessionFactory sessionFactory;

	/**
	 * �ײ�ʹ����Ϣ
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	public Salers findSalersInfo(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Salers where uid=?");
		query.setInteger(0, userid);
		Salers salers = (Salers) query.uniqueResult();
		if (salers != null)
			return salers;
		else
			return null;
	}

	/**
	 * ע���ײ�ʹ��
	 */
	@Transactional
	public Salers addSalersInfo(int userid, String code, String idcode,
			String invcodes) {
		Session session = sessionFactory.getCurrentSession();
		Salers s = new Salers();
		s.setUid(userid);
		s.setCode(code);
		s.setIdcode(idcode);
		s.setCreationtime(new Timestamp(System.currentTimeMillis()));
		s.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		// �����ײ�ʹ����Ϣ
		Serializable sb = session.save(s);
		if (sb != null) {
			Query query = session.createQuery("from Salers where uid=?");
			query.setInteger(0, userid);
			s = (Salers) query.uniqueResult();
			// �޸�������ʹ����
			query = session.createQuery("from Invcodes where code=?");
			query.setString(0, invcodes);
			Invcodes i = new Invcodes();
			i.setSid(s.getId());
			session.update(i);
			return s;
		}
		return null;
	}
}
