package bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.Addresses;

import bs.dao.BsAddressDao;

@Service
public class BsAddressService {
	@Resource
	BsAddressDao bsAddressDao;
	
	public List<Addresses> findAddressInfo(int uid){
		return bsAddressDao.findAddressInfo(uid);
	}
}
