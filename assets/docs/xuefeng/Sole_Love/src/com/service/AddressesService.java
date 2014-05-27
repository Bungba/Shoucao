package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.AddressesDao;
import com.model.Addresses;

@Service
public class AddressesService {
	@Resource
	AddressesDao addressesDao;

	public List<Addresses> findAddInfo(int userid) {
		return addressesDao.findAddInfo(userid);
	}

	public List<Addresses> addAddressInfo(int userid, Addresses addresses) {
		return addressesDao.addAddressInfo(userid, addresses);
	}

	public List<Addresses> updateAddressInfo(int userid, Addresses addresses) {
		return addressesDao.updateAddressInfo(userid, addresses);
	}

	public List<Addresses> delAddressInfo(int userid, int addressId) {
		return addressesDao.delAddressInfo(userid, addressId);
	}
}
