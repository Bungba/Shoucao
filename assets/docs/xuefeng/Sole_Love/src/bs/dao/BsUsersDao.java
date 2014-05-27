package bs.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Invcodes;
import com.model.Salers;
import com.model.Users;
import com.util.MD5Util;



@Repository
public class BsUsersDao {
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Users> findUser(){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users");
		List<Users> list=query.list();
		return list;
	}
	
	@Transactional
	public boolean updateUsers(Users users){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(users);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public boolean updateUserFlag(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users where id=?");
		query.setInteger(0, id);
		Users u=(Users)query.uniqueResult();
		if (u.getDelflag()==0) {
			u.setDelflag(1);
		}else{
			u.setDelflag(0);
		}
		try {
			session.update(u);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public boolean wxUpdateUser(Users users){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(users);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

	
	@Transactional
	public boolean wxApplySaler(int id,String invcodes,String mobile,String idcode,String address){
		
		Session session = sessionFactory.getCurrentSession();
		Salers s=new Salers();
		s.setUid(id);
		s.setIdcode(idcode);
		//s.setCode(code);
		s.setCreationtime(new Timestamp(System.currentTimeMillis()));
		s.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		Serializable sb= session.save(s);
		if(sb!=null){
			Users u=new Users();
			u.setId(id);
			u.setMobile(mobile);
			u.setAddress(address);
			u.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			try {
				session.update(u);
			} catch (Exception e) {
				return false;
			}
			Invcodes i=new Invcodes();
			Query query=session.createQuery("from Invcodes where code=?");
			query.setString(0, invcodes);
			i=(Invcodes)query.uniqueResult();
			i.setSid(id);
			i.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			try {
				session.update(i);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	@Transactional
	public boolean wxResetPassword(int id,String password){
		Session session = sessionFactory.getCurrentSession();
		MD5Util md5 = new MD5Util();
		Users users=new Users();
		users.setId(id);
		users.setPassword(md5.string2MD5(password));
		try {
			session.update(users);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
