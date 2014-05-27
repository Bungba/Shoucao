package bs.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Html;

@Repository
public class BsNewsDao {
	@Resource
	SessionFactory sessionFactory;

	@Transactional
	public List<Html> findHTMLCode() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Html");
		List<Html> list=query.list();
		return list;
	}
	
	
	@Transactional
	public Html findHTMLCode(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Html where id=?");
		query.setInteger(0, id);
		Html h = (Html) query.uniqueResult();
		return h;
	}

	@Transactional
	public boolean addHTMLCode(Html html) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(html);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public boolean updateHTML(Html html){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(html);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
