package bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Addresses;

@Repository
public class BsAddressDao {
	@Resource
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Addresses> findAddressInfo(int uid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Addresses where uid=?");
		query.setInteger(0, uid);
		List<Addresses> list=query.list();
		return list;
	}
}
