package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UsersDao;
import com.model.Users;

@Service
public class UsersService {

	@Resource
	UsersDao usersDao;

	public List<Users> findUsersInfo() {
		return usersDao.findUsersInfo();
	}

	public Users addUserInfo(Users users) {
		return usersDao.addUserInfo(users);
	}

	public boolean check_email_or_mobile_existed(String mobile, String email) {
		return usersDao.check_email_or_mobile_existed(mobile, email);
	}

	public Users login(String mobile, String email, String password) {
		return usersDao.login(mobile, email, password);
	}

	public Users updateUserInfo(int userid, String tel, String address) {
		return usersDao.updateUserInfo(userid, tel, address);
	}
}
