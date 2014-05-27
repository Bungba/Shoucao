package bs.service;


import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.model.Orders;
import com.model.Users;


import bs.dao.BsOrdersDao;

@Service
public class BsOrdersService {
	
	@Resource
	BsOrdersDao bsOrdersDao;
	
	public List<Orders> findOrderInfo() {
		return bsOrdersDao.findOrderInfo();
	}
	
	public List findOrderUser(){
		return bsOrdersDao.findOrderUser();
	}
	
	public List findOrderdetails(){
		return bsOrdersDao.findOrderdetails();
	}
	
	public Users findUserName(int id){
		return bsOrdersDao.findUserName(id);
	}
	
	public boolean updateOrdersFlag(int id){
		return bsOrdersDao.updateOrdersFlag(id);
	}
	
	public List findUserOrders(int id){
		return bsOrdersDao.findUserOrders(id);
	}
}
