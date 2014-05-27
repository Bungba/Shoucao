package com.service;

import java.util.List;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Repository;

import com.dao.GreetingsDao;
import com.model.Greetings;

@Repository
public class GreetingsService {
	@Resource
	GreetingsDao greetingsDao;

	public List<Greetings> findGreetingsInfo(int userid) {
		return greetingsDao.findGreetingsInfo(userid);
	}

	public List<Greetings> addGreetingInfo(int userid, String char_id,
			String bg_id, String sound) {
		return greetingsDao.addGreetingInfo(userid, char_id, bg_id, sound);
	}
	public boolean addGreetingInfo(String char_id,String bg_id,String sound,String code){
		return greetingsDao.addGreetingInfo(char_id, bg_id, sound, code);
	}
	public Greetings findGreetingInfo(int id){
		return greetingsDao.findGreetingInfo(id);
	}
	public boolean updateGreeting(int id,String char_id,String bg_id,String sound,String code){
		return greetingsDao.updateGreeting(id,char_id, bg_id, sound, code);
	}
}
