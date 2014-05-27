package bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bs.dao.BsUsersDao;

import com.model.Users;



@Service
public class BsUserService {
	@Resource
	BsUsersDao bsUsersDao;
	
	public List<Users> findUser(){
		return bsUsersDao.findUser();
	}
	public boolean updateUsers(Users users){
		return bsUsersDao.updateUsers(users);
	}
	public boolean updateUserFlag(int id){
		return bsUsersDao.updateUserFlag(id);
	}
	public boolean wxUpdateUser(Users users){
		return bsUsersDao.wxUpdateUser(users);
	}
	public boolean wxApplySaler(int id,String invcodes,String mobile,String idcode,String address){
		return bsUsersDao.wxApplySaler(id,invcodes, mobile, idcode, address);
	}
	public boolean wxResetPassword(int id,String password){
		return bsUsersDao.wxResetPassword(id, password);
	}
}
