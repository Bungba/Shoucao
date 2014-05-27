package com.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Greetings;
import com.model.Usergreetings;

@Repository
public class GreetingsDao{
	
	@Resource
	SessionFactory sessionFactory;
	/**
	 * 当前user使用过的祝福列表
	 * @param userid
	 * @return list
	 */
	@Transactional
	public List<Greetings> findGreetingsInfo(int userid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Greetings g,Usergreetings ug  where g.id=ug.gid AND ug.uid=? order by ug.usecount desc");
		query.setInteger(0, userid);
		ArrayList list=(ArrayList) query.list();
		Iterator iterator = list.iterator(); 
		if (iterator.hasNext()) { 
			//Object[] o = (Object[]) iterator.next();
			//System.out.println((Greetings)o[0]);
			return list;
		}
		return null;
	}
	
	/**
	 * 用户新建祝福
	 */
	@Transactional
	public List<Greetings> addGreetingInfo(int userid,String char_id,String bg_id,String sound){
		Session session=sessionFactory.getCurrentSession();
		Greetings g=new Greetings();
		g.setBackground(bg_id);
		g.setCharactor(char_id);
		g.setSound(sound);
		g.setCreationtime(new Timestamp(System.currentTimeMillis()));
		g.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		Serializable sb=session.save(g);
		if (sb!=null) {
			Usergreetings ug=new Usergreetings();
			ug.setUid(userid);
			ug.setGid(Integer.parseInt(sb.toString()));
			ug.setCreationtime(new Timestamp(System.currentTimeMillis()));
			ug.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			Serializable sb1=session.save(ug);
			if (sb1!=null) {
				Query query=session.createQuery("from Greetings where uid=?");
				query.setInteger(0, userid);
				List<Greetings> list=query.list();
				return list;
			}
			return null;
		}
		return null;
	}
	/**
	 * 新建祝福
	 */
	@Transactional
	public boolean addGreetingInfo(String char_id,String bg_id,String sound,String code){
		Session session=sessionFactory.getCurrentSession();
		Greetings g=new Greetings();
		g.setBackground(bg_id);
		g.setCharactor(char_id);
		g.setSound(sound);
		g.setCode(code);
		g.setCreationtime(new Timestamp(System.currentTimeMillis()));
		Serializable sb=session.save(g);
		if (sb!=null) {
			return true;
		}
		return false;
	}
	@Transactional
	public boolean updateGreeting(int id,String char_id,String bg_id,String sound,String code){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Greetings where id=?");
		query.setInteger(0, id);
		Greetings g=(Greetings)query.uniqueResult();
		g.setBackground(bg_id);
		g.setCharactor(char_id);
		g.setSound(sound);
		g.setCode(code);
		g.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		try {
			session.update(g);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public Greetings findGreetingInfo(int id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Greetings where id=?");
		query.setInteger(0, id);
		Greetings g=(Greetings)query.uniqueResult();
		return g;
	}
}
