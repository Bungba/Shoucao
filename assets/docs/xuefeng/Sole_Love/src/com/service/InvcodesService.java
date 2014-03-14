package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.InvcodesDao;

@Service
public class InvcodesService {

	@Resource
	InvcodesDao invcodesDao;

	public boolean findInvcodesInfo(String invcodes) {
		return invcodesDao.findInvcodesInfo(invcodes);
	}
}
