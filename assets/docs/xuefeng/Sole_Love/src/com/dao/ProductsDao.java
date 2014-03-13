package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Products;
@Repository
public class ProductsDao {
	@Resource
	SessionFactory sessionFactory;
	@Transactional
	public List<Products> findProductsInfo(){
		Session session=sessionFactory.getCurrentSession();//获得session
		Query query=session.createQuery("from Products");//查询Products数据
		List<Products> list=query.list();//添加list集合
		return list;
	}
}
