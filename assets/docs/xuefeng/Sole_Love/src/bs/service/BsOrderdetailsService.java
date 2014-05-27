package bs.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.model.Orderdetails;


import bs.dao.BsOrderdetailsDao;


@Service
public class BsOrderdetailsService {
	
	@Resource
	BsOrderdetailsDao bsorderdetailsDao;
	
	public List<Orderdetails> findOrderdetailsInfo() {
		return bsorderdetailsDao.findOrderdetailsInfo();
	}
	public List<Orderdetails> findOrderdetailsInfo(int id) {
		return bsorderdetailsDao.findOrderdetailsInfo(id);
	}
}
