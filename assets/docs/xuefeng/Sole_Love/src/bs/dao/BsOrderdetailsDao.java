package bs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Orderdetails;




@Repository
public class BsOrderdetailsDao {
	@Resource
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Orderdetails> findOrderdetailsInfo() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Orderdetails");
		List<Orderdetails> list=query.list();
		return list;
	}
	@Transactional
	public List<Orderdetails> findOrderdetailsInfo(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orderdetails where oid=?");
		query.setInteger(0, id);
		List<Orderdetails> list=query.list();
		return list;
	}
}
