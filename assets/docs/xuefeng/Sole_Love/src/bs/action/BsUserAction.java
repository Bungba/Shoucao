package bs.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Users;
import com.service.UsersService;
import com.util.MD5Util;

import bs.service.BsUserService;

@Controller
@Scope("prototype")
public class BsUserAction {
	@Resource
	BsUserService bsUserService;
	@Resource
	UsersService usersService;
	
	List<Users> list=new ArrayList<Users>();
	
	public String findUsers(){
		list=bsUserService.findUser();
		return "success";
	}
	int id;
	String nickname;
	int gender;
	String birthday;
	String marriageday;
	String tel;
	int qq;
	String city;
	String address;
	int locked;
	String password;
	String mobile;
	String email;
	
	boolean result;
	public String updateUsers() throws ParseException{
		Users u=new Users();
		u.setId(id);
		u.setNickname(nickname);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		u.setBirthday(date);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(marriageday);
		u.setMarriageday(date1);
		u.setTel(tel);
		u.setQq(qq);
		u.setCity(city);
		u.setAddress(address);
		u.setGender(gender);
		u.setLocked(locked);
		u.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		if (bsUserService.updateUsers(u)==true) {
			result=true;
		}else{
			result=false;
		}
		return "success";
	}

	public String addUsers() throws ParseException{
		MD5Util md5 = new MD5Util();
		Users u=new Users();
		u.setNickname(nickname);
		u.setPassword(md5.string2MD5(password));
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		u.setBirthday(date);
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(marriageday);
		u.setMarriageday(date1);
		u.setTel(tel);
		u.setQq(qq);
		u.setCity(city);
		u.setAddress(address);
		u.setGender(gender);
		u.setLocked(locked);
		u.setMobile(mobile);
		u.setEmail(email);
		u.setDelflag(0);
		u.setCreationtime(new Timestamp(System.currentTimeMillis()));
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		if (usersService.addUserInfo(u,ip)!=null) {
			result=true;
		}else{
			result=false;
		}
		return "success";
	}
	
	
	public String updateUserFlag(){
		bsUserService.updateUserFlag(id);
		return "success";
	}
	
	public String wxUpdateUser() throws ParseException{
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if (u!=null) {
			if (nickname!=null) {
				u.setNickname(nickname);
			}
			if (gender==0) {
				u.setGender(0);
			}else if(gender==1){
				u.setGender(1);
			}
			if (birthday!=null) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				u.setBirthday(date);
			}
			if (marriageday!=null) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(marriageday);
				u.setMarriageday(date1);
			}
			if (tel!=null) {
				u.setTel(tel);
			}
			if (qq!=0) {
				u.setQq(qq);
			}
			if (city!=null) {
				u.setCity(city);
			}
			if (address!=null) {
				u.setAddress(address);
			}
			u.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			result=bsUserService.wxUpdateUser(u);
		}
		return "success";
	}
	String invcodes;
	String idcode;
	public String wxApplySaler(){
		result= bsUserService.wxApplySaler(id, invcodes, mobile, idcode, address);
		return "success";
	}
	
	public String wxResetPassword(){
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("User");
		if(u!=null){
			result=bsUserService.wxResetPassword(u.getId(), password);
		}else{
			result=false;
		}
		return "success";
	}
	
	
	public BsUserService getBsUserService() {
		return bsUserService;
	}

	public void setBsUserService(BsUserService bsUserService) {
		this.bsUserService = bsUserService;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMarriageday() {
		return marriageday;
	}

	public void setMarriageday(String marriageday) {
		this.marriageday = marriageday;
	}


	public int getQq() {
		return qq;
	}

	public void setQq(int qq) {
		this.qq = qq;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getInvcodes() {
		return invcodes;
	}

	public void setInvcodes(String invcodes) {
		this.invcodes = invcodes;
	}


}
