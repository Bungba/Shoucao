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

import com.model.Discounts;
import com.model.Invcodes;
import com.model.Rankings;
import com.model.Salers;
import com.model.Users;

@Repository
public class SalersDao {
	/**
	 * 根据用户ID查询首草使者信息
	 */
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 首草使者信息
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
	 * 注册首草使者
	 * 
	 * 加入排行榜
	 */
	@Transactional
	public Salers addSalersInfo(int userid, String idcode, String invcodes) {
		Session session = sessionFactory.getCurrentSession();
		Salers s = new Salers();
		s.setUid(userid);
		// s.setCode(code); 后台生成优惠代码
		s.setIdcode(idcode);
		s.setCreationtime(new Timestamp(System.currentTimeMillis()));
		s.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		// 保存首草使者信息
		Serializable sb = session.save(s);
		joinRanking(sb, userid);// 加入排行榜
		joinDiscounts(userid);//创建返点记录
		if (sb != null) {
			Query query = session.createQuery("from Salers where uid=?");
			query.setInteger(0, userid);
			s = (Salers) query.uniqueResult();
			// 修改邀请码使用者
			query = session.createQuery("from Invcodes where code=?");
			query.setString(0, invcodes);
			Invcodes i = new Invcodes();
			i.setSid(s.getId());
			session.update(i);
			return s;
		}
		return null;
	}

	/**
	 * 加入排行榜
	 */
	public void joinRanking(Serializable sb, int userid) {
		Session session = sessionFactory.getCurrentSession();
		if (sb != null) {
			Query q = session.createQuery("from Users where id=?");
			q.setInteger(0, userid);
			Users u = (Users) q.uniqueResult();
			Rankings r = new Rankings();
			r.setSaleroom(0);
			r.setName(u.getNickname());
			r.setCity(u.getCity());
			r.setCreationtime(new Timestamp(System.currentTimeMillis()));
			r.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			Serializable sb1 = session.save(r);
			if (sb1 == null) {
				System.out.println("加入排行榜失败");
			}
		}
	}

	/**
	 * 创建返点记录
	 */
	public void joinDiscounts(int userid) {
		Session session = sessionFactory.getCurrentSession();
		if (userid != 0) {
			Discounts discounts = new Discounts();
			discounts.setSid(userid);
			discounts.setAmount(0f);
			discounts
					.setCreationtime(new Timestamp(System.currentTimeMillis()));
			discounts.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			Serializable sb1 = session.save(discounts);
			if (sb1 == null) {
				System.out.println("创建返点记录失败");
			}
		}
	}
}
