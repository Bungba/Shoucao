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

	public List<Greetings> findGreetingsInfo(int userid) {
		return greetingsDao.findGreetingsInfo(userid);
	}

	public List<Greetings> addGreetingInfo(int userid, String char_id,
			String bg_id, String sound) {
		return greetingsDao.addGreetingInfo(userid, char_id, bg_id, sound);
	}
}
