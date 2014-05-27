package bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bs.dao.BsGreetingsDao;

import com.model.Greetings;
@Service
public class BsGreetingsService {
	@Resource
	BsGreetingsDao bsGreetingsDao;
	
	public List findGreeting(){
		return bsGreetingsDao.findGreeting();
	}
}
