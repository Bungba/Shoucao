package com.model;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String nickname;
     private Integer gender;
     private Date birthday;
     private Date marriageday;
     private String tel;
     private Integer qq;
     private String city;
     private String address;
     private String mobile;
     private String email;
     private String password;
     private Integer delflag;
     private Integer locked;
     private Timestamp lockedtime;
     private Timestamp lastlogintime;
     private Timestamp updatetime;
     private Timestamp creationtime;


    // Constructors

    /** default constructor */
    public Users() {
    }

    
    /** full constructor */
    public Users(String nickname, Integer gender, Date birthday, Date marriageday, String tel, Integer qq, String city, String address, String mobile, String email, String password, Integer delflag, Integer locked, Timestamp lockedtime, Timestamp lastlogintime, Timestamp updatetime, Timestamp creationtime) {
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
        this.marriageday = marriageday;
        this.tel = tel;
        this.qq = qq;
        this.city = city;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.delflag = delflag;
        this.locked = locked;
        this.lockedtime = lockedtime;
        this.lastlogintime = lastlogintime;
        this.updatetime = updatetime;
        this.creationtime = creationtime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return this.gender;
    }
    
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getMarriageday() {
        return this.marriageday;
    }
    
    public void setMarriageday(Date marriageday) {
        this.marriageday = marriageday;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getQq() {
        return this.qq;
    }
    
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDelflag() {
        return this.delflag;
    }
    
    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Integer getLocked() {
        return this.locked;
    }
    
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Timestamp getLockedtime() {
        return this.lockedtime;
    }
    
    public void setLockedtime(Timestamp lockedtime) {
        this.lockedtime = lockedtime;
    }

    public Timestamp getLastlogintime() {
        return this.lastlogintime;
    }
    
    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Timestamp getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Timestamp getCreationtime() {
        return this.creationtime;
    }
    
    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }
   








}