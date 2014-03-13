package com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Greetings;
import com.model.Greetingss;

@Repository
public class GreetingsDao{
	
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Greetings> findGreetingsInfo(int userid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Greetings g,Usergreetings ug  where g.id=ug.gid AND ug.uid=? order by ug.usecount desc");
		query.setInteger(0, userid);
		ArrayList list=(ArrayList) query.list();
		Iterator iterator = list.iterator(); 
		while (iterator.hasNext()) { 
			Object[] o = (Object[]) iterator.next();
			//System.out.println((Greetings)o[0]);
		}
		return null;
	}
}
