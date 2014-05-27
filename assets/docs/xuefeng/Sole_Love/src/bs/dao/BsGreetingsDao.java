package bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Greetings;

@Repository
public class BsGreetingsDao {
	@Resource
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List findGreeting(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Usergreetings us,Users u,Greetings g WHERE us.uid=u.id AND us.gid=g.id");
		List list=query.list();
		return list;
	}
	
	
}
