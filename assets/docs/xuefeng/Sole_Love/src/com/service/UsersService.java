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

	public Users findUsersInfo(int userid) {
		return usersDao.findUsersInfo(userid);
	}

	public Users addUserInfo(Users users,String ip) {
		return usersDao.addUserInfo(users,ip);
	}

	public boolean check_email_or_mobile_existed(String mobile, String email) {
		return usersDao.check_email_or_mobile_existed(mobile, email);
	}

	public Users login(String ip,String mobile, String email, String password) {
		return usersDao.login(ip,mobile, email, password);
	}

	public Users updateUserInfo(int userid, String tel, String address) {
		return usersDao.updateUserInfo(userid, tel, address);
	}

	public void loginDate(String mobile, String email) {
		usersDao.loginDate(mobile, email);
	}

	public void unlock(String mobile, String email) {
		usersDao.unlock(mobile, email);
	}

	public void locked(String mobile, String email) {
		usersDao.locked(mobile, email);
	}
	public void lockedDel(String mobile, String email) {
		usersDao.lockedDel(mobile, email);
	}
}
