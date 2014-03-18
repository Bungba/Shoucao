package com.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Discounts;
import com.model.Salers;
import com.model.Users;
import com.util.FirstAndLastDate;

@Repository
public class DiscountsDao {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 当前用户每月返点记录
	 * 
	 * @param salerid
	 * @return discounts
	 */
	@Transactional
	public Discounts findDisInfo(int salerid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Discounts where sid=?");
		query.setInteger(0, salerid);
		Discounts discounts = (Discounts) query.uniqueResult();
		if (discounts != null) {
			return discounts;
		}
		return null;
	}
	
	/**
	 * 更新返点记录
	 * 1.获得当月的销售额
	 * 2.根据当月的销售额更新返点记录
	 */
	@Transactional
	@Scheduled(cron = "59 59 23 * * ?")     //每天23点59分59秒更新返点记录
	public void updateDisInfo(){
		Session session = sessionFactory.getCurrentSession();
		Query query=null;
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT s.uid,SUM(price)");
		sb.append(" FROM orders o,orderdetails od,users u");
		sb.append(" WHERE u.id=o.uid");
		sb.append(" AND o.id=od.oid");
		sb.append(" AND u.id=s.uid");
		sb.append(" AND o.paied =0");
		sb.append(" AND o.returned=0");
		sb.append(" AND o.creationtime BETWEEN DATE_FORMAT('?','%Y-%m-%d')  AND DATE_FORMAT('?','%Y-%m-%d')");
		sb.append(" GROUP BY u.id");
		query=session.createSQLQuery(sb.toString());
		FirstAndLastDate fd=new FirstAndLastDate();
		query.setString(0, fd.firstDate());
		query.setString(1, fd.lastDate());
		List list = query.list();
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object[] obj = (Object[]) i.next();
			Discounts discounts=new Discounts();
			discounts.setSid(Integer.parseInt(obj[0].toString()));
			discounts.setAmount((Float)obj[1]);
			discounts.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			session.update(discounts);
		}
	}
	/**
	 * 每月第一天创建当月的返点记录
	 */
	@Transactional
	@Scheduled(cron = "0 0 0 1 * ?")     //每月1点0分0秒创建新返点记录
	public void createDisInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Salers");
		List<Salers> salerid=query.list();
		for (int i = 0; i < salerid.size(); i++) {
			Discounts discounts = new Discounts();
			discounts.setSid(salerid.get(i).getUid());
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
