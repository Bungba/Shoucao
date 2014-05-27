package bs.dao;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Products;



@Repository
public class BsProductsDao {
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public Products findProductsName(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Products where id=?");
		query.setInteger(0, id);
		Products p=(Products)query.uniqueResult();
		return p;
	}
	@Transactional
	public List<Products> findProducts(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Products");
		List<Products> list=query.list();
		return list;
	}
	@Transactional
	public boolean updateProducts(Products products){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(products);
		} catch (Exception e) {
			return false;
		}
		return true;
	} 
	@Transactional
	public boolean delproducts(Products p){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(p);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
