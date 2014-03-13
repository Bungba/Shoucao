package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dao.GreetingsDao;
import com.model.Greetings;

@Repository
public class GreetingsService {
	@Resource
	GreetingsDao greetingsDao;
	
	public List<Greetings> findGreetingsInfo(int userid){
		return greetingsDao.findGreetingsInfo(userid);
	}
}
