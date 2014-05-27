package com.service;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.InfosDao;
import com.model.Infos;

@Service
public class InfosService {

	@Resource
	InfosDao infosDao;

	public Infos checkVerify(String verify) {
		return infosDao.checkVerify(verify);
	}
}
