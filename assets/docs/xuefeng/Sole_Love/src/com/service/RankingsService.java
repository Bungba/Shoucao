package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import com.dao.RankingsDao;
import com.model.Rankings;

@Service
public class RankingsService {

	@Resource
	RankingsDao rankingsDao;

	public List<Rankings> findRankingInfo() {
		return rankingsDao.findRankingInfo();
	}
}
