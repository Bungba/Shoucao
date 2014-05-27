package com.model;

import java.sql.Timestamp;


/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer uid;
     private String city;
     private String zip;
     private String address;
     private String name;
     private String code;
     private Integer gid;
     private Float discount;
     private String message;
     private String express;
     private Float expressFee;
     private Boolean paied;
     private Boolean returned;
     private Boolean delFlag;
     private Timestamp updatetime;
     private Timestamp creationtime;


    // Constructors

    /** default constructor */
    public Orders() {
    }

    
    /** full constructor */
    public Orders(Integer uid, String city, String zip, String address, String name, String code, Integer gid, Float discount, String message, String express, Float expressFee, Boolean paied, Boolean returned, Boolean delFlag, Timestamp updatetime, Timestamp creationtime) {
        this.uid = uid;
        this.city = city;
        this.zip = zip;
        this.address = address;
        this.name = name;
        this.code = code;
        this.gid = gid;
        this.discount = discount;
        this.message = message;
        this.express = express;
        this.expressFee = expressFee;
        this.paied = paied;
        this.returned = returned;
        this.delFlag = delFlag;
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

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGid() {
        return this.gid;
    }
    
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Float getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getExpress() {
        return this.express;
    }
    
    public void setExpress(String express) {
        this.express = express;
    }

    public Float getExpressFee() {
        return this.expressFee;
    }
    
    public void setExpressFee(Float expressFee) {
        this.expressFee = expressFee;
    }

    public Boolean getPaied() {
        return this.paied;
    }
    
    public void setPaied(Boolean paied) {
        this.paied = paied;
    }

    public Boolean getReturned() {
        return this.returned;
    }
    
    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public Boolean getDelFlag() {
        return this.delFlag;
    }
    
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
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