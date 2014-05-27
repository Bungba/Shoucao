package bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Orders;
import com.model.Users;



@Repository
public class BsOrdersDao {
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Orders> findOrderInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orders");
		List<Orders> list =query.list();
		return list;
	}
	
	@Transactional
	public List findOrderUser(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("SELECT o.id,o.city,o.zip,o.address,o.name,o.code,o.discount,o.message,o.express,o.express_fee,o.paied,o.returned,o.del_flag,o.updatetime,o.creationtime,SUM(os.price),SUM(os.count),u.nickname,u.gender,u.birthday,u.marriageday,u.tel,u.qq,u.mobile,u.email FROM Orders o,Orderdetails os,Users u WHERE o.id=os.oid AND o.uid=u.id GROUP BY os.oid ");
		List list=query.list();
		return list;
	}
	@Transactional
	public List findOrderdetails(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("FROM Orderdetails os,Products p WHERE os.pid=p.id");
		List list=query.list();
		return list;
	}
	@Transactional
	public Users findUserName(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Users where id=?");
		query.setInteger(0, id);
		return (Users)query.uniqueResult();
	}
	@Transactional
	public boolean updateOrdersFlag(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Orders where id=?");
		query.setInteger(0, id);
		Orders o=(Orders)query.uniqueResult();
		if (o.getDelFlag()) {
			o.setDelFlag(false);
		}else{
			o.setDelFlag(true);
		}
		try {
			session.update(o);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public List findUserOrders(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("SELECT o.id,p.image,p.title,p.price,os.count FROM Orderdetails os,Products p,Orders o WHERE o.uid=? AND o.id=os.oid AND os.pid=p.id ORDER BY o.id");
		query.setInteger(0, id);
		List list=query.list();
		return list;
	}
}
